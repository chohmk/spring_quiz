package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson06.bo.BookingBO;
import com.quiz.lesson06.model.Booking;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Quiz03Controller {
	@RequestMapping("/add_booking_view")
	public String addBookingView(
			Booking booking,
			Model model) {
		
		model.addAttribute("bookign",booking);
		Booking currentBooking = BookingBO
		return "lesson06/addBooking";
	}
	
	
}
