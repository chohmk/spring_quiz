package com.quiz.lesson06.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.bo.Favorite;
import com.quiz.lesson06.bo.List;

@Repository
public interface FavoriteDAO {

	public void insertFavorite(
			@Param("title") String title, 
			@Param("address") String address);
	
	public List<Favorite> selectFavorite();
}
