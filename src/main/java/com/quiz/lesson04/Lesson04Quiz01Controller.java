package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;

@Controller
@RequestMapping("/lesson04/quiz01")
public class Lesson04Quiz01Controller {
	@Autowired
	private SellerBO sellerBO;
	
	// 요청 URL: http://localhost:8080/lesson04/quiz01/add_seller_view
	@RequestMapping(path="/add_seller_view", method = RequestMethod.GET)
	
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	//요청 URL: http://localhost:8080/lesson04/quiz01/add_seller
	@PostMapping("/add_seller")
	public String addSeller(
			@RequestParam("nickName") String nickName,
			@RequestParam("profileImageUrl") String profileImageUrl,
			@RequestParam("temperature") double temperature) {	
		
		// db insert
		sellerBO.addSeller(nickName, profileImageUrl, temperature);
		
		// 결과 jsp
		return "lesson04/afterAddSeller";
	}
}
