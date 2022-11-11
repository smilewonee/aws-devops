package net.cj.edu.aws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @restController를 사용한다.
// rest Controller와 일반 Controller의 차이는..
// rest Controller는 데이터 전송용이며, 페이지 이동을 위해선 Controller를 쓰면 된다.
// 일반 Controller는 a.jsp를 a.jsp로 리턴하고, rest jsp는 a.jsp를 "a.jsp"로 리턴하기 때문이다.

@RestController
public class MainController {

	@GetMapping("/")
	
	public String home() {
		return "<h1>Hi, aws-devops</h1>"; // 저장만 하면 재기동 됨. spring devtools를 설치해서그렇다
	}

}
