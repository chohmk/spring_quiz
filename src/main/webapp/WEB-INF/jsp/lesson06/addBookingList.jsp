<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 		<!-- datepicker 라이브러리 위에 있어야 한다.  -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        

        <!-- datepicker 라이브러리 -->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        
        <!-- bootstrap CDN link -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <!-- jquery slim 제거-->
        <!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/css/fensyeon.css">
</head>
<body>
<div class="container">
 	<div>
 		<label for="name">이름</label>
 		<input type="text" id="name" name="name" class="form-control col-5">
 	</div>
 	
 	<div>
 		<label for="date">예약날짜</label>
 		<input type="text" id="date" name="date" class="form-control col-5">
 	</div>
 	
 	<div>
 		<label for="day">숙박일수</label>
 		<input type="text" id="day" name="day" class="form-control col-5">
 	</div>
 	
 	<div>
 		<label for="headcount">숙박인원</label>
 		<input type="text" id="headcount" name="headcount" class="form-control col-5">
 	</div>
 	
 	<div>
 		<label for="phoneNumber">전화번호</label>
 		<input type="text" id="phoneNumber" name="phoneNumber" class="form-control col-5">
 	</div>
 	
 	<button type="button" id="reservationBtn" class="form-control col-5 bg-warning">예약하기</button>
</div>
</body>

<script>
	$(document).ready(function() {
		$('input[name=date]').datepicker({
			dateFormat: "yy-mm-dd"
			, minDate:0	// 오늘부터 뒤 선택
		});
	});
	
	$('#reservationBtn').on('click', function() {
		// alert("예약하기");
		
		// 값 가져오기
		let name = $('input[name=name]').val().trim();
		let date = $('input[name=date]').val().trim();
		let day = $('input[name=day]').val().trim();
		let headcount = $('input[name=headcount]').val().trim();
		let phoneNumber = $('input[name=phoneNumber]').val().trim();
		
		// validation
		if (name == "") {
			alert("이름을 입력하세요");
			return;
		}
		
		if (date == "") {
			alert("날짜를 입력하세요");
			return;
		}
		
		if (day == "") {
			alert("숙박일을 입력하세요");
			return;
		}
		
		if (isNaN(day)) {	// 문자x 숫자만 o isNaN
			alert("숙박일수를 숫자로 입력하세요");
			return;
		}
		
		if (headcount == "") {
			alert("숙박인원을 입력하세요");
			return;
		}
		
		if (isNaN(headcount)) {
			alert("숙박인원을 숫자로 입력하세요");
			return;
		}
		
		if (phoneNumber == "") {
			alert("전화번호를 입력하세요");
			return;
		}
		
		
		// ajax -> insert
		$.ajax({
			// request			
			type:"POST"
			, url:"/lesson06/add_bookingList"
			, data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
		
			// response
			, success:function(data) {
				if (data.code == 100 ) {
					alert("예약되었습니다.");
					location.href = "/lesson06/add_booking_view";
				} else {
					alert(data.errorMessage);
				}
			}
			, error:function(e) {
				alert("예약하는데 실패했습니다.");
			}
		});
		
	});
</script>
</html>