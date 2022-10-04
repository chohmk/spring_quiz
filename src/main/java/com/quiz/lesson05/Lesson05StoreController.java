package com.quiz.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05StoreController {
	@RequestMapping("/store")
	public String StoreView() {
		return "/lesson05/store";
	}
}
