package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.FavoriteBO;
import com.quiz.lesson06.model.Favorite;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {
	@Autowired
	private FavoriteBO favoriteBO;

	@RequestMapping("/add_favorite_view")
	public String addFavorite() {
		return "lesson06/addFavorite";
	}
	
	// AJAX가 호출하는 API => @ResponseBody가 있어야함.
	@PostMapping("/add_favorite")
	@ResponseBody
	public String addFavorite(
			@RequestParam("title") String title,
			@RequestParam("address") String address) {
		
		favoriteBO.addFavorite(title, address);
		
		return "성공";
	}
	@RequestMapping("/get_favorite")
	public String getFavorite(
			List<Favorite> favorite
			Model model) {
		
		List<Favorite> favorite = favoriteBO.getFavorite();
		
		model.addAttribute("favorite", favorite);
		return "lesson06/getFavorite";
	}
	
}
