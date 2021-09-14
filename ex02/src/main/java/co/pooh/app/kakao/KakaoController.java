package co.pooh.app.kakao;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class KakaoController {
	@RequestMapping("/kakao")
	public String login() {
		return "login/kakao";
	}
	
	@GetMapping("/kakao/login")
	@ResponseBody
	public String kakao(String code) { //카카오 인증 코드
		//post방식으로 key&value 데이터를 요청(카카오쪽으로)
		RestTemplate rt = new RestTemplate();
		
		//HttpHeader 오브젝트 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//HttpBody 오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "5986adbc56a3444841aed3bd67e4976d");
		params.add("redirect_uri", "http://localhost:8080/app/kakao/login");
		params.add("code", code); //code는 동적
		
		//HttpHeader, HttpBody를 하나의 오브젝트에 담기 -> 왜 여기에 담아? 밑에 있는 exchange 함수가 HttpEntity를 받아서....
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
				new HttpEntity<>(params, headers); //header, param 값을 가진 엔터티
		
		//POST 방식으로 Http 요청하기 , 그리고 response 변수에 응답받기
		ResponseEntity<String> response = rt.exchange(
				"https://kauth.kakao.com/oauth/token",
				HttpMethod.POST,
				kakaoTokenRequest,
				String.class
				);
		
		
		return "kakao response : " + response;
	}
}
