package co.pooh.app.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/loginForm")
	public String login() {
		
		return "emp/login";
	}
	
}