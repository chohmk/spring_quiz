package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String addBookingView(Model model) {
		List<Booking> book = bookingBO.getBooking();
		model.addAttribute("book", book);

		return "lesson06/addBooking";
	}
	
	@DeleteMapping("/delete_booking")
	@ResponseBody
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {

		// 삭제 db
		int deleteCount = bookingBO.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (deleteCount > 0) {
			result.put("code", 100);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("errorMessage", "삭제할 예약 내역이 없습니다.");
		}
		return result;
	}

//	
//	 delete // AJAX 호출 API
//	  
//	  @ResponseBody
//	  
//	  @DeleteMapping("/delete_booking") public Map<String, Object> deleteBooking(
//	  
//	  @RequestParam("id") int id){ Map<String, Object> result = new HashMap<>();
//	  int deleteRow = bookingBO.deleteBooking(id); if (deleteRow > 0) {
//	  result.put("code", 100); result.put("result", "성공"); } else {
//	  result.put("code", 500); result.put("errorMessage", "삭제하는데 실패하였습니다."); }
//	  
//	  return result;
//	  
//	  }
//	 

	@RequestMapping("/add_bookingList_view")
	public String addBookingList() {
		return "lesson06/addBookingList";
	}
	
	@ResponseBody
	@PostMapping("/add_bookingList")
	public Map<String, Object> addBookingList (
			@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		int addCount = bookingBO.addBookingList(name, date, day, headcount, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		if (addCount > 0) {
			result.put("code", 100);
			result.put("success", "성공");
		} else {
			result.put("code", 500);
			result.put("errorMessage", "데이터를 입력하는데 실패했습니다.");
		}
		
		return result;
	}
	
	@RequestMapping("/main_view")
	public String booking() {
		return "lesson06/mainView";
	}
	
	// AJAX의 요청
	@ResponseBody
	@PostMapping("/search_booking")
	public Map<String, Object> searchBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingBO.getLatestBooking(name, phoneNumber);
		Map<String, Object> result = new HashMap<>();
		if (booking != null) {
			result.put("code", 100);	// 데이터 있음
			result.put("booking", booking);
		} else {	
			result.put("code", 400);	// 데이터 없음
		}
		
		return result;
	}
}
