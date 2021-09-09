package co.pooh.app.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.pooh.app.board.mapper.BoardAttachMapper;
import co.pooh.app.board.service.BoardService;
import co.pooh.app.board.vo.BoardAttachVO;
import co.pooh.app.board.vo.BoardVO;
import co.pooh.app.board.vo.Criteria;
import co.pooh.app.board.vo.PageVO;

@Controller
@RequestMapping("/board/*")
//@SessionAttributes("criteria")
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired BoardAttachMapper attachMapper;

	// 전체 조회
	@GetMapping("/list") // 뷰페이지가 list라면, void타입으로 해도된다. 다른 거라면 return string~
	public void list(Model model, Criteria criteria) {
		int totalCount = boardService.getTotalCount(criteria);
		model.addAttribute("list", boardService.getList(criteria));
		model.addAttribute("pageMaker", new PageVO(criteria, totalCount));
	}

	// 단건조회
	@GetMapping("/get")
	public void read(Model model, BoardVO vo, Criteria criteria) { // 파라미터로 받는 "커맨드 객체"
		model.addAttribute("board", boardService.read(vo));
	}

	// 등록 페이지
	@GetMapping("/register")
	public void registerForm() {

	}

	// 수정 페이지
	@PostMapping("/modifyForm")
	public void modifyForm(Model model, BoardVO vo) {
		model.addAttribute("board", boardService.read(vo));
	}

	// 등록 처리
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr, MultipartFile[] uploadFile)
			throws IllegalStateException, IOException {
		List<BoardAttachVO> list = new ArrayList<BoardAttachVO>();
		String path = "c:/upload";
		for (int i = 0; i < uploadFile.length; i++) {
			MultipartFile ufile = uploadFile[i];
			if (!ufile.isEmpty() && ufile.getSize() > 0) {
				BoardAttachVO attachvo = new BoardAttachVO();
				String filename = ufile.getOriginalFilename();
//				String saveName = System.currentTimeMillis()+"";
				UUID uuid = UUID.randomUUID();
				File file = new File(path, uuid + filename);
				ufile.transferTo(file);
				attachvo.setUuid(uuid.toString());
				attachvo.setFileName(filename);
				attachvo.setUploadPath(path);
				list.add(attachvo);
			}
		}

		vo.setAttachList(list);

		boardService.insert(vo);

		rttr.addFlashAttribute("result", "success");

		return "redirect:/board/list"; // 파라미터 전달 X, 그래서 rttr 씀
	}

	// 수정 처리
	@PostMapping("/modify")
	public String modify(BoardVO vo, Criteria criteria, RedirectAttributes rttr) {
		int result = boardService.update(vo);

		if (result == 1) {
			rttr.addFlashAttribute("result", "success");
		}

		rttr.addAttribute("pageNum", criteria.getPageNum());
		rttr.addAttribute("amount", criteria.getAmount());

		return "redirect:/board/list"; // 파라미터 전달 X, 그래서 rttr 씀
	}

	// 삭제 처리
	@PostMapping("/delete")
	public String delete(BoardVO vo, RedirectAttributes rttr) {
		int result = boardService.delete(vo);

		if (result == 1) {
			rttr.addFlashAttribute("result", "success");
		}

		return "redirect:/board/list"; // 파라미터 전달 X, 그래서 rttr 씀
	}

	@RequestMapping(value = "/download")
	public void cvplFileDownload(@RequestParam Map<String, Object> commandMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String atchFileId = (String) commandMap.get("uuid");
		
		BoardAttachVO vo = attachMapper.read(atchFileId);
		
		String filename = "";
		
		if (vo != null) {
			filename = vo.getFileName();			
		}
		
		File uFile = new File("c:/upload", atchFileId+filename);
		long fSize = uFile.length();
		if (fSize > 0) {
			String mimetype = "application/x-msdownload";
			response.setContentType(mimetype);
			 response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(filename, "utf-8") + "\"");
//			setDisposition(atchFileId, request, response);
			BufferedInputStream in = null;
			BufferedOutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(uFile));
				out = new BufferedOutputStream(response.getOutputStream());
				FileCopyUtils.copy(in, out);
				out.flush();
			} catch (IOException ex) {
			} finally {
				in.close();
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
		} else {
			response.setContentType("application/x-msdownload");
			PrintWriter printwriter = response.getWriter();
			printwriter.println("<html>");
			printwriter.println("<h2>Could not get file name:<br>" + atchFileId + "</h2>");
			printwriter.println("<center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
			printwriter.println("&copy; webAccess");
			printwriter.println("</html>");
			printwriter.flush();
			printwriter.close();
		}
	}
}
