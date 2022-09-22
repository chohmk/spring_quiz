package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.model.RealEstate;

@RestController
public class Lesson03Quiz01RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	// 요청URL: http://localhost:8080/lesson03/quiz01_1?id=20
	@RequestMapping("/lesson03/quiz01_1")
	public RealEstate quiz01_1(
			@RequestParam("id") int id
	) {
		return realEstateBO.getRealEstate(id);
	}
	
	
	// 요청 URL: http://localhost:8080/lesson03/quiz01_2?rentPrice=90
	@RequestMapping("/lesson03/quiz01_2")
	public List<RealEstate> quiz01_2(
			@RequestParam("rentPrice") int rentPrice
		) {
		return realEstateBO.getRealEstateByRentPrice(rentPrice);
	}
	
	// 요청 URL: http://localhost:8080/lesson03/quiz01_3?area=90&price=130000
	@RequestMapping("/lesson03/quiz01_3")
	public List<RealEstate> quiz01_3(
			@RequestParam("area") int area,
			@RequestParam("price") int price
	){
		return realEstateBO.getSelect2(area, price);
	}
	
	
}
