package com.yedam.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yedam.app.impl.EmpMapper;

import lombok.extern.java.Log;

@Controller
@Log
public class HomeController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		//request.setAttribute("속성명", 값);
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; //forward
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/login")
	public String login(Member member) {
		log.info(member.toString());  //error>info>warn>debug>trace. 나중에 error로 바꿔버리면 그 이후 4개는 안 뜬다.
		return "redirect:/";
	}
	
	@Autowired EmpMapper dao;
	@RequestMapping("/dept")
	public String dept(Model model) {
		model.addAttribute("list", dao.getDept());
		return "dept";
	}
}
