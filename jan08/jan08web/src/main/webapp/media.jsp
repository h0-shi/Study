<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>미디어 쿼리 연습</title>
<style type="text/css">
/*공통 css*/
body{
	background-color: grey;
}
/* desktop 규격*/
@media screen and (min-width : 1024px){
	body{
		background-color: lightblue;
	}
}
/* tablet 규격*/ 
@media screen and (max-width : 1023px){
	body{
		background-color: green;
	}
}
/*모바일 규격*/
@media screen and (max-width : 540px){
	body{
		background-color: #yellow;
	}
}
</style>
<script type="text/javascript">
console.log(window.innerWidth);
console.log(window.innerHeight);

window.onresize = function(event){
	document.getElementById('size').textContent = window.innerWidth+"x"+window.innerHeight;
}
</script>
</head>
<body>
	<h1 id="size">너비 : </h1>

</body>
</html>