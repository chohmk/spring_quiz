package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookingBO;
import com.quiz.lesson06.model.Booking;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Quiz03Controller {
	@Autowired
	private BookingBO bookingBO;
	@RequestMapping("/add_booking_view")
	public String addBookingView(
			Booking booking,
			Model model) {
		List<Booking> book = bookingBO.getBooking();
		model.addAttribute("book",book);
		
		return "lesson06/addBooking";
	}
	
	
	
	
	
	
	
	
	/* delete */
	// AJAX 호출 API
	@ResponseBody
	@DeleteMapping("/delete_booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id){
		Map<String, Object> result = new HashMap<>();
		int deleteRow = bookingBO.deleteBooking(id);
		if (deleteRow > 0) {
			result.put("code", 100);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("errorMessage", "삭제하는데 실패하였습니다.");
		}
		
		return result;
				
	}
	
	
}
