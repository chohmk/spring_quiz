package com.quiz.lesson05.dao;

import org.springframework.stereotype.Repository;

import com.quiz.lesson05.bo.WeatherHistory;

@Repository
public interface WeatherHistoryDAO {
	public void insertWeatherhistory();
}
