package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson01/quiz03")
public class lesson01Quiz03ViewResolver {

	// 요청 URL : http://localhost/lesson01/quiz03/1
	@RequestMapping("/1")
	public String quiz03() {

	//    	/WEB-INF/jsp/	lesson01/quiz03	.jsp
		return "lesson01/quiz03";
	}
}
