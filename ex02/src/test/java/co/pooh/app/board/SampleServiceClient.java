package co.pooh.app.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.pooh.app.member.service.SampleService;
import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class SampleServiceClient {
	@Autowired SampleService sampleService;
	
	@Test
	public void test() {
		String str = "no1 120000000000";
		sampleService.addData(str);
		
		log.info("length = " + str.getBytes().length);
	}
}
