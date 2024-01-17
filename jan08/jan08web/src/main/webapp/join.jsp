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
						<h1>회원가입</h1>
						<div class="mx-3 p-3 bg-warning rounded">
							<form action="./join" method="post">
								<div class="input-group mb-2">
									<span class="input-group-text" id="inputGroup-sizing-sm">이&emsp;름</span>
									<input type="text" id="id" name="id"  class="form-control" placeholder="이름 입력">
								</div>
								<div class="input-group mb-2" >
									<span class="input-group-text" id="inputGroup-sizing-sm">아이디</span>
									<input type="text" id="id" name="id"  class="form-control" placeholder="아이디 입력">
								</div>
								<div class="input-group mb-2">
									<label class="input-group-text">암&emsp;호</label>
									<input type="password" id="pw1" name="pw1"  class="form-control" placeholder="암호 입력">
									<label class="input-group-text">재입력</label>
									<input type="password" id="pw2" name="pw2"  class="form-control" placeholder="암호 재입력">
								</div>
								<div class="input-group mb-2">
									<button type="reset" class="btn btn-danger">초기화</button>
									<button type="submit" class="btn btn-primary">가입</button>
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