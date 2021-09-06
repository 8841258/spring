package co.pooh.app.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.pooh.app.board.service.EmployeesService;
import co.pooh.app.emp.domain.EmpCriteria;
import co.pooh.app.emp.domain.EmployeesVO;
import lombok.extern.java.Log;

@Log
@RequestMapping("/emp/*")
@Controller
public class EmployeeController {
	@Autowired EmployeesService service;
	
	@GetMapping("/list")
	public void list(Model model, EmpCriteria cri) {
		model.addAttribute("list", service.getList(cri));
	}
	
	@GetMapping("/registerForm")
	public void registerForm() {
		
	}
	
	@GetMapping("/read")
	public void read(Model model, EmployeesVO vo) {
		System.out.println(vo.getEmployeeId());
		model.addAttribute("emp", service.read(vo));
	}
	
	@PostMapping("/updateForm")
	public void update(Model model, EmployeesVO vo) {
		model.addAttribute("emp", service.read(vo));
	}
}
