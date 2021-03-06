package co.pooh.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.pooh.app.emp.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired EmpService empService;
	
	@RequestMapping("emplist")
	public String getList(Model model) {
		model.addAttribute("list", empService.getList());
		
		return "no/emp/list";
	}
	
	
}
