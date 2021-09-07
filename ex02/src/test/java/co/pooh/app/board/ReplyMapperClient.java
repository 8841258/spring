package co.pooh.app.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.pooh.app.board.service.ReplyService;
import co.pooh.app.board.vo.Criteria;
import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class ReplyMapperClient {
	
	@Autowired ReplyService service;
	
	@Test
	public void test() {

		log.info(service.getList(new Criteria(1, 5), 1L).toString());
	}

}
