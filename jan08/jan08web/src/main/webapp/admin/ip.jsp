<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IP 관리</title>
<link href="../css/admin.css?ver=0.19" rel="stylesheet"/>
<link href="../css/adminBoard.css?ver=0.00003" rel="stylesheet" />
<script type="text/javascript" src="../js/menu.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script type="text/javascript">
	google.charts.load('current', {'packages':['bar']});
	google.charts.setOnLoadCallback(drawChart);


     function drawChart() {
       var data = google.visualization.arrayToDataTable([
         ['IP', '접속량'],
         <c:forEach items="${ipTop }" var="top">
         ['${top.iip}', ${top.idata }],
         </c:forEach>
     ]);

     var options = {
    	chart: {
    		title: '접속순위 5명',
    		subtitle: '-',
    	},
    	bars: 'horizontal' // Required for Material Bar Charts.
    	};

        var chart = new google.charts.Bar(document.getElementById('barchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      }
    </script>
</head>
<body>
	<div class="wrap">
		<!-- menu -->
		<%@ include file="menu.jsp" %>
		<div class="main">
			<article>
				<h2>IP관리</h2>
					<div id="barchart_material" style="width: 600px; height: 400px;"></div>
					<h3>가장 많이 접속한 ip</h3>
							<c:forEach items="${ipTop }" var="top">
							[${top.iip } | ${top.idata }]
							</c:forEach>
					<hr>
					<h3>가장 최근에 접속한 ip</h3>
						
				<div class="nav-lists">
					<ul class="nav-lists-group">
						<li class="nav-lists-item" onclick="url('./ip?distinct')"><i class="xi-close-circle-o"></i> 중복없이 보기 </li>					
					</ul>
					<div class="search">
						<input type="text" id="search">
						<button id="searchBtn">검색</button>
						<button id="reset" onclick="url('./ip')">초기화</button>
					</div>
				</div>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>Ip</th>
						<th>날짜</th>
						<th>접속 경로</th>
						<th>사용 로그</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="row">
						<tr class="row${row.del }">
							<td class="d1">${row.ino }</td>
							<td class="d2" onclick="url('./ip?iip=${row.iip }')">${row.iip }</td>
							<td class="d1">${row.idate }</td>
							<td class="d1">${row.iurl }</td>
							<td class="d1" onclick="url('${row.iurl}?${row.idata }')">${row.idata }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</article>
		</div>
	</div>

</body>
</html>