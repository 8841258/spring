package co.pooh.app.kakao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KakaoController {
	@RequestMapping("/kakao")
	public String login() {
		return "login/kakao";
	}
	
	@GetMapping("/kakao/login")
	@ResponseBody
	public String kakao(String code) { //카카오 인증 코드
		return code;
	}
}
