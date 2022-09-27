package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.model.Realtor;

@Controller
@RequestMapping("/lesson04/quiz02")
public class Lesson04Quiz02Controller {
	@Autowired
	private RealtorBO realtorBO;
	
	// 요청 URL: http://localhost:8080/lesson04/quiz02/add_realtor_view
	@RequestMapping("/add_realtor_view")
	public String addRealtorView() {
		// 결과 jsp 경로
		return "lesson04/addRealtor";
	}
	
	@PostMapping("/add_realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		// db insert
		realtorBO.addRealtor(realtor);
		
		
		// db select
		Realtor currentRealtor = realtorBO.getRealtorById(realtor.getId());
		// model에 담는다.
		model.addAttribute("realtor", currentRealtor);
		model.addAttribute("subject", "공인중개사 정보");
		
		// return jsp 경로
		return "lesson04/quiz02/afterRealtor";
	}
}
