package com.yedam.app;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.impl.EmpMapper;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class EmpMapperClient {

	@Autowired EmpMapper dao;
	@Autowired SqlSessionTemplate mybatis;
	
	@Test
	public void mybatisTest() {
//		List<Employees> list = mybatis.selectList("com.yedam.app.impl.EmpMapper.getEmp", "10");
		List<Departments> list2 = mybatis.selectList("com.yedam.app.impl.EmpMapper.getDept");
		log.info(list2.get(0).toString());
//		log.info("job_id = " + list.get(0).getJobId());
		
	}
	
	@Test @Ignore
	public void test() {
		log.info(dao.getEmp("50").toString());
	}
	
	@Test @Ignore
	public void getTime() {
		log.info(dao.getTime());
	}

}
