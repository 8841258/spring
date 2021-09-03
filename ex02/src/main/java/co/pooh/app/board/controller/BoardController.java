package co.pooh.app.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.pooh.app.board.service.BoardService;
import co.pooh.app.board.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired BoardService boardService;
	
	//전체 조회
	@GetMapping("/list") //뷰페이지가 list라면, void타입으로 해도된다. 다른 거라면 return string~
	public void list(Model model) {
		model.addAttribute("list", boardService.getList());
	}
	
	//단건조회
	@GetMapping("/get")
	public void read(Model model, BoardVO vo) { //파라미터로 받는 "커맨드 객체"
		model.addAttribute("board", boardService.read(vo));
	}
	
	//등록 페이지
	@GetMapping("/register")
	public void registerForm() {
		
	}
	
	//수정 페이지
	@PostMapping("/modifyForm")
	public void modifyForm(Model model, BoardVO vo) {
		model.addAttribute("board", boardService.read(vo));
	}
	
	//등록 처리
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		int result = boardService.insert(vo);
		
		if (result == 1) {
			rttr.addFlashAttribute("result", "success");			
		}
		return "redirect:/board/list";  //파라미터 전달 X, 그래서 rttr 씀
	}
	
	//수정 처리
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		int result = boardService.update(vo);
		
		if (result == 1) {
			rttr.addFlashAttribute("result", "success");			
		}
		
		return "redirect:/board/list";  //파라미터 전달 X, 그래서 rttr 씀
	}
	
	//삭제 처리
	@PostMapping("/delete")
	public String delete(BoardVO vo, RedirectAttributes rttr) {
		int result = boardService.delete(vo);
		
		if (result == 1) {
			rttr.addFlashAttribute("result", "success");			
		}
		
		return "redirect:/board/list";  //파라미터 전달 X, 그래서 rttr 씀
	}
}
