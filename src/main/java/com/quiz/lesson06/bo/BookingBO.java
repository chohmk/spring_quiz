package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.quiz.lesson06.dao.BookingDAO;
import com.quiz.lesson06.model.Booking;

@Service
public class BookingBO {
	@Autowired
	private BookingDAO bookingDAO;
	public List<Booking> getBooking() {
		return bookingDAO.selectBooking();
	}
	
	public int deleteBookingById(int id) {
		return bookingDAO.deleteBookingById(id);
	}
	
	public int addBookingList(String name, String date, int day, int headcount, String phoneNumber) {
		return bookingDAO.insertBookingList(name, date, day, headcount, phoneNumber);
	}
	
	public Booking getLatestBooking(String name, String phoneNumber) {
		List<Booking> bookingList = bookingDAO.selectBookingListByNamePhoneNumber(name, phoneNumber);	// [], 채워져있거나
		if (CollectionUtils.isEmpty(bookingList)) {
			return null;
		} 
		return bookingList.get(bookingList.size() - 1);	// 마지막 인덱스 데이터 가져옴.
	}
}
