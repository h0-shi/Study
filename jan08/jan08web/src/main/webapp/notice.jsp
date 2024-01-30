<%@page import="com.poseidon.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="./css/index.css" rel="stylesheet"/>
<link href="./css/menu.css" rel="stylesheet"/>
<script type="text/javascript" src="./js/menu.js"></script>
</head>
<body>
	<div class="container">
		<header>
			<%@ include file="menu.jsp" %>
		</header>
		<div class="main">
			<div>
				<article>
				</article>
				
				<article>
					<table>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>날짜</th>
							<th>읽음</th>
						</tr>
						<c:forEach items="${list }" var="c">
						<tr>
							<td>${c.no}</td>
							<td>${c.title}</td>
							<td>${c.write}</td>
							<td>${c.date}</td>
							<td>${c.count}</td>
						</tr>
						</c:forEach>
					</table>
				</article>
			</div>
		</div>
		<footer>
		
		</footer>
	</div>	
</body>
</html>