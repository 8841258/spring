package co.pooh.app.board;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.pooh.app.emp.domain.EmpCriteria;
import co.pooh.app.emp.mapper.EmployeesMapper;
import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class EmployeesMapperClient {

	@Autowired EmployeesMapper mapper;
	
	@Test
	@Ignore
	public void getList() {
		log.info(mapper.getList().toString());
	}
	
	@Test
	public void testPaging() {
		EmpCriteria cri = new EmpCriteria();
		cri.setPageNum(3);
		cri.setAmount(5);
		log.info(mapper.getListWithPaging(cri).toString());
	}

}
