<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.js" integrity="sha512-CX7sDOp7UTAq+i1FYIlf9Uo27x4os+kGeoT7rgwvY+4dmjqV0IuE/Bl5hVsjnQPQiTOhAX1O2r2j5bjsFBvv/A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/css/fensyeon.css">
</head>
<body>
	<div id="wrap" class="container">
	<!-- header -->
		<header>
			<div class="text-center">통나무 팬션</div>
		</header>
	<!-- nav -->
		<nav class="nav-fill">
			<ul class="nav pt-2">
				<li class="nav-item">팬션소개</li>
				<li class="nav-item">객실보기</li>
				<li class="nav-item">예약하기</li>
				<li class="nav-item">예약목록</li>
			</ul>
		</nav>
	
		<h1 class="text-center">예약 목록 보기</h1>
	
	<!-- section -->
		<section>
			<table class="table text-center">
				<thead>
				
					<tr>
						<th>이름</th>
						<th>예약날짜</th>
						<th>숙박일수</th>
						<th>숙박인원</th>
						<th>전화번호</th>
						<th>예약상태</th>
					</tr>
				
				</thead>
				<tbody>
				<c:forEach items="${book}" var="booking">
					<tr>
						<td>${booking.name}</td>
						<td>
							<fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 d일" />
						</td>
						<td>${booking.day}</td>
						<td>${booking.headcount}</td>
						<td>${booking.phoneNumber}</td>
						<td>
							<c:choose>
								<c:when test="${booking.state eq '확정'}">
									<span class="text-success">${booking.state}</span>
								</c:when>
								<c:when test="${booking.state eq '대기중'}">
									<span class="text-info">${booking.state}</span>
								</c:when>
								<c:when test="${booking.state eq '취소'}">
									<span class="text-danger">${booking.state}</span>
								</c:when>
							</c:choose>
						</td>
						<td>
							<button type="button" class="del-btn btn-danger form-control" data-booking-id="${booking.id}">삭제</button>
						</td>
						
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</section>
	</div>
	
<script>
	$(document).ready(function() {
		$('.del-btn').on('click', function() {
			let bookingId = $(this).data('booking-id');
			// alert(bookingId);
			
			$.ajax({
				// request
				type:"DELETE"
				, url: "/lesson06/delete_booking"
				, data: {"id":bookingId}
			
				// response
				, success: function(data) {
					// {"result: "success", "code":100} => 100:성공
					if (data.code == 100) {
						alert("삭제되었습니다.");
						location.reload(true);
					} else {
					// {"errorMessage: "실패 메세지", "code":500} => 500:실패
						alert(data.errorMessage);
					}
				}
				, error:function(e) {
					alert("삭제하는데 실패했습니다.");
				}
			});
		});
	});
</script>

</body>
</html>