package com.quiz.lesson06.dao;

import org.springframework.stereotype.Repository;

import com.quiz.lesson06.model.Booking;

@Repository
public class BookingDAO {
	public Booking selectBooking();
}
