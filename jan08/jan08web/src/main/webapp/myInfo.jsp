<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 보기</title>
<link href="./css/index.css" rel="stylesheet"/>
<link href="./css/menu.css" rel="stylesheet"/>
<script type="text/javascript" src="./js/menu.js"></script>

</head>
<body>
<%
if(session.getAttribute("mid")==null){
	response.sendRedirect("./login");
}
%>
	<div class="container">
		<header>
			<%@ include file="menu.jsp"%>
		</header>
		<div class="main">
			<div class="mainStyle">
				<article>
					내 정보 보기<br>
					${myInfo.mname } / ${myInfo.mid } /${myInfo.mpw }
					<div>
						<form action="./myInfo" method="post" onsubmit="return check()">
							<input type="hidden" name="mid" value="${myInfo.mid }">
							<input type="password" name="newPw" id="newPw" placeholder="mmm암호를 입력하세요">
							<button type="submit">수정하기</button>
						</form>
					</div>
					

					
				</article>
<%-- 				<table>
						<tr>
							<th>mno</th>
							<th>mid</th>
							<th>mpw</th>
							<th>mname</th>
							<th>mdate</th>
							<th>mgrade</th>
						</tr>
						<tr>
							<td>${myInfo.mno}</td>
							<td>${myInfo.mid}</td>
							<td>${myInfo.mpw}</td>
							<td>${myInfo.mname}</td>
							<td>${myInfo.mdate}</td>
							<td>${myInfo.mgrade}</td>
						</tr>
				
				</table> --%>
			</div>
		</div>
		<script type="text/javascript">
		function check(){
			//var pw = document.getElementById("newPW");
			//let reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/
			var pw = document.querySelector("#newPw");
			if(pw.value.length < 5){
				alert("암호는 5글자 이상이어야 합니다.");
				return false;				
			}
		}
		</script>
		<footer>
		<c:import url="footer.jsp"/>
		</footer>
	</div>
</body>
</html>