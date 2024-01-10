<%@page import="java.sql.Connection"%>
<%@page import="com.poseidon.db.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link href="./css/index.css" rel="stylesheet"/>
<link href="./css/menu.css" rel="stylesheet"/>
<script type="text/javascript" src="./js/menu.js"></script>

</head>
<body>
	<div class="container">
		<header>
			<%-- <%@ include file="menu.jsp" %> --%>
			<jsp:include page="menu.jsp"></jsp:include>
			<!-- jsp:는 출력 결과만 화면에 나옵니다. -->
		</header>
		<div class="main">
			<div>
				<article>
				
					<c:set var="number" value ="105"/>
					<c:out value="${number}"/> <br>
					<c:forEach begin="1" end="10" var="first" step="2">
						${2 } x ${first } =${first*2} <br>
					</c:forEach>
					<c:if test="${number eq 105 }">
						number은 105입니다.
						<!-- 
						a == b : a eq b	(equal)
						a != b : a ne b (not eaqul)
						a  < b : a lt b (little)
						a  > b : a gt b (greater)
						a <= b : a le b (little or equal)
						a >= b : a ge b (great or equal)
						&& : and
						|| : or
						empty : 비어있는지 확인
						not empty
						 -->					
					</c:if>
					<hr>
					<c:forEach begin="1" end ="45" var="row"> 
						<c:if test="${row%2 eq 0}">
							${row }
						</c:if>
					</c:forEach>
					<br>
					<c:forEach begin="1" end="9" var="fir" >
						<c:forEach begin="1" end="9" var="sec">
							${sec } x ${fir } = ${fir*sec }
						</c:forEach>
						<br>
					</c:forEach>
					
				</article>
				<article>
					<c:import url ="menu.jsp"/>
					<br>
					<c:forEach begin="1" end="10" var="row" varStatus="s">
						${s.begin } / ${s.end }
						
					</c:forEach>
				</article>
				<article>
					article
				</article>
			</div>
		</div>
		<footer>
		
		</footer>
	</div>
</body>
</html>