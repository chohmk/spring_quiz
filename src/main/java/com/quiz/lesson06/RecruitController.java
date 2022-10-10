package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson06")
@Controller
public class RecruitController {
	@RequestMapping("/add_f_view")
	public String addRecruitView() {
		return "lesson06/addF";
	}
}
