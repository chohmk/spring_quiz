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

	public void addFavorite(String title, String url) {
		favoriteDAO.insertFavorite(title, url);
	}
	
	public List<Favorite> getFavoriteList() {
		return favoriteDAO.selectFavoriteList();
	}
	
	public Favorite getFavoriteByUrl(String url) {
		List<Favorite> favoriteList = favoriteDAO.selectFavoriteByUrl(url);  // [], [{}]
		if (favoriteList.isEmpty()) {
			return null; // 중복 아니면 null 리턴 
		}
		
		return favoriteList.get(0); // 중복이면 첫번째 데이터를 리턴한다.
	}
	
	public int deleteFavorite(int id) {
		return favoriteDAO.deleteFavorite(id) ;
	}
	
}