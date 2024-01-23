<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>톺아보기</title>
<link href="./css/index.css" rel="stylesheet"/>
<link href="./css/detail.css" rel="stylesheet"/>
<link href="./css/menu.css" rel="stylesheet"/>
<script type="text/javascript" src="./js/menu.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">
$(document).ready(function(){
	//alert("준비됨");
	$("#comment-btn").click(function(){
		let content =$("#commentcontent").val();
		let bno = ${detail.no};
		//alert("content : "+content + " no : "+no);
		//가상 form 만들기 = 동적 생성
		//전송 -> content가 5글자 이상인 경우 실행한다.
		if(content.length < 5){
			alert("댓글은 5글자 이상 작성해주세요");
			$("#commentcontent").focus();
		} else {
			let form = $('<form></form>');
			form.attr('name', 'form');
			form.attr('method', 'post');
			form.attr('action', './comment');
			
			form.append($('<input/>', {type:'hidden', name:'commentcontent', value:content}));//json
			form.append($('<input/>', {type:'hidden', name:'bno', value:bno}));
			
			form.appendTo("body");
			form.submit();
			
			/*
			let form = document.createElement('form');
			form.name = 'form';
			form.method = 'post';
			form.action = './comment';
			//붙이기
			let text = document.createElement('input');
			text.setAttribute("type","hidden");
			text.setAttribute("name","commentcontent");
			text.setAttribute("value",content);
			//붙이기
			let no = document.createElement('input');
			no.setAttribute("type","hidden");
			no.setAttribute("name","bno");
			no.setAttribute("value",${detail.no});
			// form에다가 붙이기
			form.appendChild(text);
			form.appendChild(no);
			//전송하기
			document.body.appendChild(form);
			form.submit();
			*/
		}
	});
});

</script>
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
							<div class="detailWRITE">${detail.write }
								<c:if test="${sessionScope.mname ne null && detail.mid eq sessionScope.mid }">
								<img alt = "수정" src = "./img/edit.png" onclick="update()">
								<img alt = "삭제" src = "./img/delete.png" onclick="del()">
								</c:if>
							</div>
							<div class="detailCOUNT">${detail.ip } / ${detail.count }</div>
						</div>
						
						<div class="detailCONTENT">
							${detail.content }
						</div>
					</div>
						<c:if test="${sessionScope.mid ne null }">
							<div class="comment-write">
								<div class="comment-form">
									<!-- 여기에 댓글 작성창 만들거래요 -->
									<textarea id="commentcontent"></textarea>
									<button id="comment-btn">댓글 작성</button>
								</div>
							</div>
						</c:if>
							<!-- 댓글 출력창 -->
						<div class="comments">
							<c:forEach items="${commentList }" var="co">
								<div class="comment"></div>
									<div class="chead">
									<!-- 여기가 제목단 -->
										<div class="cname">${co.mname }님 
											<c:if test="${sessionScope.mname ne null && co.mid eq sessionScope.mid }">
												<img alt = "삭제" src = "./img/delete.png" onclick="commentDel(${co.cno})">
												<img alt = "수정" src = "./img/edit.png" onclick="CommentUpdate(${co.cno})">
											</c:if>
										</div>
										<div class="cdate">
											${co.ip } /	${co.cdate }
										</div>
									</div>
								<div class="ccomment">${co.comment }</div>
							</c:forEach>
						</div>
						<c:choose>
							<c:when test="${param.page ne null }">
								<button onclick="url('./board?page=${param.page }')">게시판으로</button>
							</c:when>
							<c:otherwise>
								<button onclick="url('./board')">게시판으로</button>
							</c:otherwise>
						</c:choose>
				</article>
				<article>
					하단 푸터 뭐시기
				</article>
			</div>
		</div>
		<footer><%@include file = 'footer.jsp' %> </footer>
	</div>
	<script type="text/javascript">
		function del(){
			//alert("삭제를 눌렀습니다.");
			if(confirm("삭제하시겠습니까?")){
			location.href="./delete?no=${detail.no }";
			}
		}
		function update(){
			if(confirm("글을 수정하시겠습니까?")){
				location.href="./update?no=${detail.no}";
			}
		}
		function commentDel(cno){
			if(confirm("댓글을 삭제하시겠습니까?")){
				location.href ='./commentDel?no=${detail.no}&cno='+cno;
			}
		}
	</script>
</body>
</html>