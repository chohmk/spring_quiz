package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.RealEstateDAO;
import com.quiz.lesson03.model.RealEstate;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateDAO realEstateDAO;
	public RealEstate getRealEstate(int id) {
		return realEstateDAO.selectRealEstateById(id);
	}
	
	public List<RealEstate> getRealEstateByRentPrice(int rentPrice) {
		return realEstateDAO.selecRealEstateByRentPrice(rentPrice);
	}
	
	public List<RealEstate> getSelect2(int area, int price) {
		return realEstateDAO.select2(area, price);
	}
	
	public int addRealEstate(RealEstate realEstate) {
		return realEstateDAO.insertRealEstate(realEstate); 
	}
	
	public int addRealEstateAsFiled(
			int realtorId, String address, int area, String type, int price, Integer rentPrice) {
		return realEstateDAO.insertRealEstateAsFiled(realtorId, address, area, type, price, rentPrice);
	}
	
	public int updateRealEstateById(int id, String type, int price) {
		return realEstateDAO.updateRealEstateById(id, type, price);
	}
	
	public void deleteRealEstateById(int id) {
		realEstateDAO.deleteRealEstateById(id);
	}
}
