package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.model.RealEstate;

@RestController
@RequestMapping("lesson03/quiz02")
public class Lesson03Quiz02RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	// 요청 URL: http://localhost:8080/lesson03/quiz02/1
	@RequestMapping("/1")
	public String quiz01_1() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸리지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		// insert
		int row = realEstateBO.addRealEstate(realEstate);
		// return String
		return "입력 성공:" + row;
	}
	
	// 요청 URL: http://localhost:8080/lesson03/quiz02/2?realtorId=5
	@RequestMapping("/2")
	public String quiz01_2(
			@RequestParam("realtorId") int realtorId
	) {
		
		int row = realEstateBO.addRealEstateAsFiled(
				realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "입력 성공:" + row;
	}
}
