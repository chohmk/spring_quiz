package com.quiz.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson04.model.Seller;

@Repository
public interface SellerDAO {
	public void insertSeller(
			@Param("nickname") String nickName, 
			@Param("profileImageUrl" )String profileImageUrl, 
			@Param("temperature") double temperature);
	
	public Seller selectLastestSeller();
	
	public Seller selectSellerById(int id);
}
