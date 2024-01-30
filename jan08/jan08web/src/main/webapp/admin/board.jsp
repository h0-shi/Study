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
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript">
$(function(){
	$('#searchBtn').click(function (){
		let search = $('#search').val();
		location.href="./board?search="+search;
	});
	
	$('.changeDel').click(function(){
		let eyes = $(this);
		let del = eyes.prev();
		let className = $(this).parents('tr');
		let bno = className.children().first().text();
		if(del.val()==1){
			alert("게시글을 비공개합니다.");
		} else {
			alert("게시글을 공개합니다.");
		}
	    $.ajax({
	    	url: './board',
	    	type: 'post',
	    	dateType: 'text',
	    	data: {'bno' : bno, 'del' : del.val()},
	    	success: function(result) {
	    		if(result==1){
	    			if(del.val()==1){
		    			className.attr('class','row0'); //className.css('backgroundColor', '#FFDC46');
						del.val(0);
						eyes.attr('class','xi-eye-off-o changeDel');
		    		} else {
		    			className.attr('class','row1'); //className.css('backgroundColor', '#ffffff');
						del.val(1);
						eyes.attr('class','xi-eye changeDel');
		    		}	    			
	    		}else{
	    			alert("문제~");
	    		}
			},
			error: function(request, status, error){
				alert("통신 오류");
			}
	    });
	    
  		/*
  		let form = $('<form></form>');
	    form.attr('method', 'post');
	    form.attr('action', './board');
	    form.append($('<input/>', {type : 'hidden', name : 'bno', value : bno}));
	    form.append($('<input/>', {type : 'hidden', name : 'del', value : del}));
	    form.appendTo('body');
	    form.submit();
	    */
	});
	
});
</script>
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
				<div class="search">
					<input type="text" id="search"><button id="searchBtn">검색</button>
				</div>
				<table>
						<tr>
							<th>no</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
							<th>IP</th>
							<th>삭제</th>
						</tr>
					<c:forEach items="${list }" var="row">
						<tr class="row${row.delete }">
							<td class="no">${row.no }</td>
							<td class="title"><a href="../detail?no=${row.no }">${row.title } <c:if test="${row.comment ne 0}"><small>${row.comment }</small></c:if></a></td>
							<td class="d2">${row.write }</td>
							<td class="d2">${row.date }</td>
							<td class="d1">${row.count }</td>
							<td class="d1">${row.ip }</td>
							<td class="d1">
								<input type="hidden" class="del" value="${row.delete }">
								<c:if test="${row.delete eq 1}"><i class="xi-eye changeDel"></i></c:if>
								<c:if test="${row.delete eq 0}"><i class="xi-eye-off-o changeDel"></i></c:if>
							</td>
						<%-- 	<td><select name="del">
								<option <c:if test="${row.delete eq 0 }">selected="selected"</c:if>value="0">0 : 삭제됨</option>
								<option <c:if test="${row.delete eq 1 }">selected="selected"</c:if>value="1">1 : 게시됨</option>
							</select></td> --%>
							
						</tr>
					</c:forEach>
				</table>
			</article>
		
		</div>
	</div>
</body>
</html>