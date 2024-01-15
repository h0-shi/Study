<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>톺아보기</title>
<link href="./css/index.css" rel="stylesheet"/>
<link href="./css/menu.css" rel="stylesheet"/>
<script type="text/javascript" src="./js/menu.js"></script>
<style type="text/css">
.detailDIV{
	width: 900px;
	height: auto;
	background-color: #c0c0c0;
	padding: 10px;
	box-sizing: border-box;
}
.detailTITLE{
	width: 100%;
	height: 50px;
	font-size: large;
	border-bottom: 5px solid black;
	line-height: 50px;
}
.detailWRITECOUNT{
	width: 100%;
	height: 50px;
}
.detailWRITE, .detailCOUNT {
	width: 50%;
	float: left;
	height: 50px;
	line-height: 50px;
}
.detailWRITE img{
	/*이미지와 글자의 정렬*/
	vertical-align: text-bottom;
}
.detailCOUNT {
	text-align: right;
}
.detailCONTENT{
	width: calc(100% - 20px);
	min-height: 300px;
	height: auto;
	margin: 10px;
	border: 1px solid green;
	box-sizing: border-box;
}
</style>
</head>
<body>
	<div class="container">
		<header>
			<%-- <jsp:include page="menu.jsp"></jsp:include> --%>
			<%@ include file="menu.jsp"%>
		</header>
		<div class="main">
			<div class="mainStyle">
				<article>
					<div class="detailDIV">
						<div class="detailTITLE">
							${detail.title }
						</div>
						<div class="detailWRITECOUNT">
							<div class="detailWRITE">${detail.write } / ${detail.mid } / ${sessionScope.mid }
							<c:if test="${detail.mid eq sessionScope.mid }">
							<img alt = "수정" src = "./img/edit.png" onclick="update()">
							<img alt = "삭제" src = "./img/delete.png" onclick="del()">
							</c:if>
							</div>
							<div class="detailCOUNT">${detail.count }</div>
						</div>
						<div class="detailCONTENT">
							${detail.content }
						</div>
					</div>
					<button onclick="url('./board')">게시판으로</button>
				</article>
			</div>
		</div>
		
		<script type="text/javascript">
			function del(){
				//alert("삭제를 눌렀습니다.");
				var ch = confirm("삭제하시겠습니까?")
				if(ch){
				location.href="./delete?no=${detail.no }";
				}
			}
			function update(){
				var ch = confirm("글을 수정하시겠습니까?");
				if(ch){
					location.href="./update?no=${detail.no}";
				}
			}
		</script>
		<footer><%@include file = 'footer.jsp' %> </footer>
	</div>
</body>
</html>