<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link href="../css/admin.css?ver=13" rel="stylesheet"/>
<script type="text/javascript" src="../js/menu.js"></script>
</head>
<body>
	<!-- 2024-01-26 관리자 페이지 만들기 -->
	<!-- 틀 -->
	<div class="wrap">
		<!-- menu -->
	<%@ include file="menu.jsp" %>
		<!-- 본문내용 -->
		<div class="main">
			<p>이 페이지에 방문한 모든 사용자는 관리자인지 검사를 한다.</p>
			<p>관리자의 경우 보여주고, 로그인 하지 않았거나 일반 사용자는 로그인 페이지로 이동한다.</p>
			<article>
				<div class="info">
					왼쪽 메뉴를 선택하세요~
				</div>
			</article>
		
		</div>
	</div>
</body>
</html>