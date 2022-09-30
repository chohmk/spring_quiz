package com.quiz.lesson05.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.dao.WeatherHistoryDAO;

@Service
public class WeatherHistoryBO {
	@Autowired
	private WeatherHistoryDAO weatherhistoryDAO;
	public void weatherhistory() {
		weatherhistoryDAO.insertWeatherhistory(weatherhistory);
	}
}
