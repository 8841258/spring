package com.yedam.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;



//pojo : 상속 X
@Component // -> 상속 @Component 상속해서 @Controller, @Service, @Repository(=dao)
@RequestMapping("/sample/*")
@Log
public class SampleController {
//	@RequestMapping(value = "/a", method = RequestMethod.POST )
//	@RequestMapping("/a")
	@GetMapping("/a")
	public String basic1() {
		log.info("basic1....................................");
		return "sample/basica";
	}
	
	@RequestMapping("/b")
	public void basic2() {
		log.info("basic2....................................");
	}
	
	@RequestMapping("/ex09") //매개변수로 넣으면 new 없이도 쓸 수 있음
	@ResponseBody // 자바 객체 -> json 스트링 변환
	public SampleVO ex07(SampleVO sample) {
		
		sample.setName("푸");
		sample.setAge(10);
		return sample;
	}
	
	@RequestMapping("/ex06/{name}/{age}")
	public void ex06(@PathVariable String name, @PathVariable String age) {
		log.info("name = " + name + ", " + "age = " + age);
	}
	
	@RequestMapping("/ex05")
	public void ex05(SampleVOList list) {
		log.info(list.toString());
	}
	
	@RequestMapping("/ex04")
	public void ex04(@RequestParam List<String> ids) {
		log.info(ids.toString());
	}
	
	@RequestMapping("/ex03")
	public void ex03(@RequestParam String[] ids) {
		log.info(Arrays.toString(ids));
	}
	
	@GetMapping("/ex02")
	public void ex02( @RequestParam(name = "username") String name, @RequestParam(required = false, defaultValue = "10") int age ) {
		log.info("name = " + name);
		log.info("age = " + age);
	}
	
	@RequestMapping("/ex01") //SampleVO는 model처리를 따로 하지 않아도 알아서~~ modelattribute를 쓰면 다른 이름으로~~~
	public String ex01( @ModelAttribute("sam") SampleVO vo, Model model) {
		log.info(vo.toString());
		model.addAttribute("pageNo", "10");
		return "sample/ex01";
	}
}
