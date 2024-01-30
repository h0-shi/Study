<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>coffee</title>
<link href="./css/index.css" rel="stylesheet" />
<link href="./css/menu.css" rel="stylesheet" />
<link href="./css/coffee.css" rel="stylesheet" />
<script type="text/javascript" src="./js/menu.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".beverage").hide();
	$(".tea").hide();
	
	$("#stype").change(function(){
		var v = document.getElementById('stype');
		if(v.value=="coffee"){
			$(".coffee").show();
			$(".beverage").hide();
			$(".tea").hide();
			
		} else if(v.value=="beverage"){
			$(".beverage").show();
			$(".coffee").hide();
			$(".tea").hide();
			
		} else if(v.value=="tea"){
			$(".tea").show();
			$(".beverage").hide();
			$(".coffee").hide();
		}
	});
	
	// 가상폼이랑 ajax중에 뭐 할지 생각해봤는데 alert 띄우려면 ajax 해야되는구나.
	$(".commit").click(function(){
		var v = document.getElementById('stype');
		var bname = document.getElementById(v.value);
		var temp = document.getElementById('temp');
		var no = "no";
//		alert(v.value+" : "+b.value+" : "+temp.value);	
		if(bname.value!="no"&&temp.value!="no"){
			if(confirm(bname.value+"("+temp.value+")으로 하시겠습니까?")){
				$.ajax({
					url: './coffee', 
					type: 'post',
					dataType: 'text',
					data: {'beverage' : bname.value, "temp" : temp.value },
					success: function(result){
						if(result==1){
							alert("주문이 체결되었습니다.");
							location.href="./coffee";
						} else {
							alert("기존 주문 취소 후 주문해주세요.");
						}
					},
					error: function(request, status, error){ //통신오류
						alert("에러 발생");
					}
				});
			} 
		} else {
			alert("주문 옵션을 확인해주세요");
		}
	});
	
});
</script>
</head>
<body>
	<div class="container">
		<header>
			<%@ include file="menu.jsp"%>
		</header>
		<div class="main">
			<article>
				<h1>커피를 먹어봅시다.</h1>
			</article>
			<div class="main">
				<div class="select">
					<div class = "temp"> Hot / Ice :
						<select name ="temp" id="temp">
							<option value="no" selected disabled hidden>선택해주세요.</option>
							<option value="hot">Hot</option>
							<option value="ice">Ice</option>
						</select>
					</div>
					<div class ="type"> 종류 : 
						<select name ="type" id="stype">
							<option value="coffee">커피</option>
							<option value="beverage">음료</option>
							<option value="tea">차</option>
						</select>
					</div>
					
					<div class="coffee"> 커피 : 
						<select name="coffee" id="coffee">
							<option value="no" selected disabled hidden>선택해주세요.</option>
							<c:forEach items="${clist }" var="c" >
								<option value="${c.beverage }">${c.beverage }</option>
							</c:forEach>		
						</select>
					</div>
					
					<div class="beverage"> 음료 : 
						<select name="beverage" id="beverage">
							<option value="no" selected disabled hidden>선택해주세요.</option>
							<c:forEach items="${blist }" var="b" >
								<option value="${b.beverage }">${b.beverage }</option>
							</c:forEach>		
						</select>
					</div>
					
					<div class="tea"> 차 : 
						<select name="tea" id="tea">
							<option value="no" selected disabled hidden>선택해주세요.</option>
							<c:forEach items="${tlist }" var="t" >
								<option value="${t.beverage }">${t.beverage }</option>
							</c:forEach>		
						</select>
					</div>
					</div>
					<div>
					<button class="commit">음료 결정</button>
					<button onclick="del()">주문 취소</button> 
					</div>
					<div>
					<h3 class="subtitle">주문량 확인</h3>
					</div>
					<article>
					<div>
						<table class="result">
							<tr class="hotresult">
								<th>뜨거운 음료</th>
								<th>주문량</th>
							</tr>
					<c:forEach items="${hot }" var="h" >
							<tr>
								<td>${h.beverage }</td>
								<td>${h.count }</td>
							</tr>
					</c:forEach>
						</table>	
						<table class="result">
							<tr class="iceresult">
								<th>차가운 음료</th>
								<th>주문량</th>
							</tr>
					<c:forEach items="${ice }" var="c" >
							<tr>
								<td>아이스 ${c.beverage }</td>
								<td>${c.count }</td>
							</tr>
					</c:forEach>
						</table>
						</div>					
					
					</article>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
		function del(){
			if(confirm("주문을 취소하시겠습니까")){
			location.href="./coffeeDel";
			}
		}
	</script>
	
		<footer>
		<c:import url="footer.jsp"/>
		</footer>

</body>
</html>