package com.yedam.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class DITest {
	
	//IoC (제어의 역행) : 객체 관리를 컨테이너가 해줌
	//DI (의존성 주입)
	
	@Autowired Employees emp; //new 객체 생성 없이 컨테이너에서 주입받음
	
	@Test
	public void test() {
		emp.getEmployeeId();
	}
}
