package co.pooh.app.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.pooh.app.board.service.ReplyService;
import co.pooh.app.board.vo.Criteria;
import co.pooh.app.board.vo.ReplyVO;

@RestController
@RequestMapping("/replies/*")
public class ReplyRestController {
	
	@Autowired ReplyService service;
	
	//해당 게시글의 댓글만 조회
	@GetMapping("/")
	public List<ReplyVO> getList(Criteria cri, @RequestParam long bno) {
		
		return service.getList(cri, bno);
	}
	
	@GetMapping("/{rno}")
	public ReplyVO read(@PathVariable long rno, ReplyVO vo) {
		vo.setRno(rno);
		return service.read(vo);
	}
	
	//등록
	@PostMapping("/")    //post : 파라미터는 질의문자열(query string) -> ?id=100&pw=111&name=choi
	public ReplyVO insert(ReplyVO vo) {
		service.insert(vo);
		return service.read(vo);
	}
	
	//수정
	@PutMapping("/")  	//put&delete : 파라미터는 JSON -> {id : 100, pw : "111", name : "choi"}
	public ReplyVO update(@RequestBody ReplyVO vo) {
		service.update(vo);
		return service.read(vo);
	}
	
	//삭제
	@DeleteMapping("/{rno}")
	public boolean delete(@PathVariable long rno, ReplyVO vo) {
		vo.setRno(rno);
		int result = service.delete(vo);
		return result == 1 ? true : false;
	}
}
