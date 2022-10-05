package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.FavoriteDAO;
import com.quiz.lesson06.model.Favorite;

@Service
public class FavoriteBO {
	@Autowired
	private FavoriteDAO favoriteDAO;
	
	public void addFavorite(String title, String address) {
		favoriteDAO.insertFavorite(title, address);
	}
	
	public List<Favorite> getFavorite(String title, String address){
		return favoriteDAO.selectFavorite(title, address);
	}
}
