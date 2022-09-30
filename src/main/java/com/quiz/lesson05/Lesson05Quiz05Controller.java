package com.quiz.lesson05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.bo.WeatherHistoryBO;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Quiz05Controller {
	@Autowired
	private WeatherHistoryBO weatherhistoryBO;
	@RequestMapping("/weatherhistory")
	public String addWeatherHistoryView(
			Model model) {
		
		weatherhistoryBO.weatherhistory(weatherhistory);
		model.addAttribute("weatherhistory",weatherhistory);
		
		return "lesson05/weatherhistory";
	}
	
	
}
