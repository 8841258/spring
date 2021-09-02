package com.yedam.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
public class AjaxController {

	@RequestMapping("/ex07") //매개변수로 넣으면 new 없이도 쓸 수 있음
	public SampleVO ex07(SampleVO sample) {
		
		sample.setName("푸");
		sample.setAge(10);
		return sample;
	}
	
	@RequestMapping("/ex08")
	public List<SampleVO> ex08() {
		List<SampleVO> list = new ArrayList<>();
		list.add(new SampleVO("pooh", 10, new Date()));
		list.add(new SampleVO("tiger", 9, new Date()));
		list.add(new SampleVO("piglet", 8, new Date()));
		
		return list;
	}
	
	
}
