<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link href="../css/admin.css?ver=13" rel="stylesheet"/>
<link href="../css/adminBoard.css" rel="stylesheet"/>
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
			<article>
				<h2>게시글 관리</h2>
				<table>
						<tr>
							<th>no</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
							<th>댓글 수</th>
							<th>IP</th>
							<th>삭제</th>
						</tr>
					<c:forEach items="${list }" var="row">
						<tr class="row${row.delete }">
							<td>${row.no }</td>
							<td class="title"><a href="../detail?no=${row.no }">${row.title }</a></td>
							<td>${row.write }</td>
							<td>${row.date }</td>
							<td>${row.count }</td>
							<td>${row.comment }</td>
							<td>${row.ip }</td>
							<td><select>
								<option <c:if test="${row.delete eq 0 }">selected="selected"</c:if>value="0">0 : 삭제됨</option>
								<option <c:if test="${row.delete eq 1 }">selected="selected"</c:if>value="1">1 : 게시됨</option>
							</select></td>
						</tr>
					</c:forEach>
				</table>
			</article>
		
		</div>
	</div>
</body>
</html>