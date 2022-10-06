<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.js" integrity="sha512-CX7sDOp7UTAq+i1FYIlf9Uo27x4os+kGeoT7rgwvY+4dmjqV0IuE/Bl5hVsjnQPQiTOhAX1O2r2j5bjsFBvv/A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
	<h1>즐겨찾기 추가하기</h1>
		<div class="form-group">
			<label for="name" >제목</label>
			<input type="text" id="name" name="name" class="form-control">
		</div>
		<div class="form-group">
			<label for="url">주소</label>
			<div class="d-flex">
				<input type="text" id="url" name="url" class="form-control">
				<button type="button" id="checkBtn" class="btn btn-info">중복확인</button>
			</div>
			<small id="isDuplicationText" class="text-danger d-none">중복된 url 입니다.</small>
			<small id="availableText" class="text-success d-none">저장 가능한 url 입니다.</small>
		</div>
		<button type="button" id="addBtn" class="btn btn-success w-100">추가</button>
	
</div>

<script>
$(document).ready(function(){
	
	$('#addBtn').on('click', function(e){
		e.preventDefault();
		let name = $('#name').val().trim();
		if (name.length < 1) {
			alert("제목을 입력하세요");
			return;
		}
		let url = $('#url').val().trim();
		if (url.length < 1) {
			alert("url을 입력하세요");
			return;
		}
		
		// 중복 확인 완료 확인
		if ($('#availableText').hasClass('d-none')) {  // d-none이 있으면 확인 안된 것
			alert("중복된 url 입니다. 중복확인을 해주세요");
			return;
		}
		
		$.ajax({
			type:"post"
			,url:"/lesson06/add_favorite"
			,data:{"title":name, "url":url}
		
			,success:function(data){
				if (data == "성공") {
					location.href = "/lesson06/favorite_list_view"
				}
			}
			
			,error:function(e){
				alert("error:" +e);
			}
			
		});
		
	});
	
	
	// url 중복확인
	$('#checkBtn').on('click', function() {
		let url = $('#url').val().trim();
		if (url == "") {
			alert("검사할 url을 입력하세요");
			return;
		}
		
		// 중복 검사 db 
		$.ajax({
			// request
			type:"POST"
			, url:"/lesson06/is_duplication_url"
			, data:{"url":url}
		
			// response 
			, success:function(data) {   // json string => object 화(jquery ajax 함수가 파싱해줌)
				if (data.isDuplication) {
					// 중복
					$('#isDuplicationText').removeClass('d-none');
					$('#availableText').addClass('d-none');
				} else {
					// 사용 가능
					$('#isDuplicationText').addClass('d-none');
					$('#availableText').removeClass('d-none');
				}
			}
			, error:function(e) {
				alert("중복확인에 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
	});
	
	
});
</script>

</body>
</html>