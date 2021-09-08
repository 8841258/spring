package co.pooh.app.board;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.pooh.app.user.domain.UserService;
import co.pooh.app.user.domain.UserVO;
import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class AopClient {
	
	@Autowired UserService userService;
	
	@Test
	@Ignore
	public void Test() {
		
		
		userService.getUserList(null);
		
	}
	
	@Test
	public void test1() {
		UserVO vo = new UserVO();
		vo.setId("test");
		
		userService.getUser(vo);
	}
}
