package co.pooh.app.board.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.pooh.app.board.service.BoardService;
import co.pooh.app.board.vo.BoardVO;

@Controller
public class BoardRestController {
	
	@RequestMapping("test1")
	@ResponseBody
	public Map<String, Object> test1(@RequestParam String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(id.equals("admin")) 
			map.put("result", id);
		else 
			map.put("result", false);
		
		return map;
	}
	
	@Autowired BoardService boardService;
	
	@RequestMapping(
					value="test2",
					produces = "application/json; charset=UTF-8"
					)
	@ResponseBody
	public BoardVO test2(BoardVO vo) {
		
		return vo;
	}
	
}
