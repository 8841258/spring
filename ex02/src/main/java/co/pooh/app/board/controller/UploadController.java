package co.pooh.app.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.pooh.app.board.vo.BoardVO;
import lombok.extern.java.Log;

@Log
@Controller
public class UploadController {
	@PostMapping("uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFile) throws IllegalStateException, IOException {
		for (int i = 0; i < uploadFile.length; i++) {
			MultipartFile ufile = uploadFile[i];
			if (!ufile.isEmpty() && ufile.getSize() > 0) {
				String filename = ufile.getOriginalFilename();
				String saveName = System.currentTimeMillis()+"";
				File file = new File("c:/upload", saveName);
				ufile.transferTo(file);
			}
		}
	}
	
	@PostMapping("uploadAjaxAction")
	@ResponseBody
	public boolean uploadAjaxAction(MultipartFile[] uploadFile, BoardVO vo) throws IllegalStateException, IOException {
		log.info("BoardVO = " + vo);
		boolean result = false;
		for (int i = 0; i < uploadFile.length; i++) {
			MultipartFile ufile = uploadFile[i];
			if (!ufile.isEmpty() && ufile.getSize() > 0) {
				String filename = ufile.getOriginalFilename();
//				String saveName = System.currentTimeMillis()+"";
				UUID uuid = UUID.randomUUID();
				File file = new File("c:/upload", uuid+filename);
				ufile.transferTo(file);
				result = true;
			}
		}
		return result;
	}
}
