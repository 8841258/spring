package co.pooh.app.board;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.pooh.app.board.service.BoardService;
import co.pooh.app.board.vo.BoardVO;
import co.pooh.app.board.vo.Criteria;
import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class BoardMapperClient {

	@Autowired BoardService boardMapper;
	
	@Test
//	@Ignore
	@Rollback
	public void getList() {
		Criteria criteria = new Criteria(1, 100);
		criteria.setType("C");
		criteria.setKeyword("화장실");
		log.info(boardMapper.getList(criteria).toString());
	}
	
	@Test
	@Ignore
	@Rollback
	public void insert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("안녕! 이것은 제목");
		vo.setContent("안녕! 이것은 내용");
		vo.setWriter("푸");
		boardMapper.insert(vo);
	}
	
	@Test
	@Ignore
	@Rollback
	public void read() {
		BoardVO vo = new BoardVO();
		vo.setBno(6);
		vo = boardMapper.read(vo);
		log.info(vo.toString());
	}

	@Test
	@Ignore
	public void update() {
		BoardVO vo = new BoardVO();
		vo.setBno(3);
		vo.setTitle("3번 제목 수정~~~!!!!!!!!");
		vo.setContent("안녕! 3번 내용 수정");
		int result = boardMapper.update(vo);
		assertEquals(result, 1);
	}
	
	@Test
	@Ignore
	@Rollback
	public void delete() {
		BoardVO vo = new BoardVO();
		vo.setBno(2);
		boardMapper.delete(vo);
	}
}
