<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="./css/index.css" rel="stylesheet"/>
<link href="./css/menu.css" rel="stylesheet"/>
<script type="text/javascript" src="./js/menu.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<style type="text/css">
.alert{
	color: red;
}
</style>
<script type="text/javascript">
		//$(document).ready(function(){}); 의 다른 모양(축약형)
		$(function(){
			$('.id-alert, .name-alert, .pw-alert').hide();
		});

		function check(){
		//alert("제이쿼리가 동작합니다.");
		//$(선택자).할일();
		let name = $('#name').val();
		if(name.length<3){
			$('.name-alert').show();
			$("#name").focus();
			return false;
		}
		$('.name-alert').hide();
		
		let id = $("#id").val();
		if(id.length<3||id==""){
			//alert("잘못된 아이디입니다. 다시 입력해주세요");
			$('.id-alert').show();
			$("#id").focus();
			return false;
		}
		$('.id-alert').hide();
		
		let pw1 = $('#pw1').val();
		let pw2 = $('#pw2').val();
		if(pw1.length<4){
			alert("비밀번호는 4글자 이상이여야 해.")
			$("#pw1").focus();
			$('.pw-alert').show();
			return false;
		} else if(pw1 != pw2) {
			alert("암호가 일치하지 않습니다.")
			$("#pw2").focus();
			$("#pw2").val("");
			return false;
		}
		$('.pw-alert').hide();
		
		//alert(id+" : "+id.length + " 숫자 검사 : "+isNaN(id)); // Not a Number
		}
		
		function idCheck(){
			//alert('버튼 실행');
			let id = $('#id').val();
			const regEXP = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g;//한글 정규식
			if(id.length<5||regEXP.test(id)){
				alert("아이디는 5글자 이상의 영어여야함");
				$('#id').focus();
			} else {
				//alert(id);
				$.ajax({
					url : './idCheck', // 서블릿 - 어디로 보낼건지
					type : 'post', // get or post
					dataType : 'text', // 데이터 타입은 뭔지
					data : {'id' : id}, // 보낼 이름 : 값
					success: function(result){
						if(result==0){
							alert("사용 가능한 ID입니다.");
						} else {
							alert("이미 사용중인 ID입니다.")
						}
					},
					error : function(request, status, error){
						alert("문제 발생");
					}
				});
			}
			return false;
		}
</script>
</head>
<body>
	<div class="container1">
		<header>
			<%@ include file="menu.jsp"%>
		</header>
		<div class="main">
			<div class="mainStyle">
				<article>
				
					<div class="join-form">
						<div class="mx-3 p-3 bg-warning rounded">
						<h1>회원가입</h1>
							<form action="./join" method="post" onsubmit="return check()">
								<div class="input-group mb-2" >
									<span class="input-group-text" id="inputGroup-sizing-sm">아이디</span>
									<input type="text" id="id" name="id"  class="form-control" placeholder="아이디 입력">
									<button class="input-group-text" onclick="return idCheck()">중복확인</button>
								</div>
								<div class="input-group mb-2 id-alert">
									<p class="alert">올바른 아이디을 입력해주시오</p>
								</div>
								<div class="input-group mb-2">
									<span class="input-group-text" id="inputGroup-sizing-sm">이&emsp;름</span>
									<input type="text" id="name" name="name"  class="form-control" placeholder="이름 입력">
								<div class="input-group mb-2 name-alert">
									<p class="alert">올바른 이름을 입력해주시오</p>
								</div>
								</div>
								<div class="input-group mb-2">
									<label class="input-group-text">암&emsp;호</label>
									<input type="password" id="pw1" name="pw1"  class="form-control" placeholder="암호 입력">
									<label class="input-group-text">재입력</label>
									<input type="password" id="pw2" name="pw2"  class="form-control" placeholder="암호 재입력">
								</div>
								<div class="input-group mb-2 pw-alert">
									<p class="alert">올바른 패스워드를 입력해주시오</p>
								</div>
								<div class="input-group mb-2">
									<button type="reset" class="btn btn-danger">초기화</button>
									<button type="submit" class="btn btn-primary">가입하기</button>
								</div>
							</form>
						</div>
					</div>
				</article>
			</div>
		</div>
		<footer>
		<c:import url="footer.jsp"/>
		</footer>
	</div>
</body>
</html>