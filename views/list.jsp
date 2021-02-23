<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<script type="text/javascript" src="/item/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(function() {
		//버튼을 클릭했을때
		$('#btnList').on('click', function() {
			const findKey = $('#findKey').val();
			const findValue = $('#findValue').val();
			console.log(findKey);
			console.log(findValue);
			
			//ajax 통신
			$.ajax({
				type: 'post',
				url:'/item/item/list',
				data: {findKey,findValue}, //key와 값이 같을때 한쪽은 생략 가능
				dataType:'json', //돌려받는 데이터 형태
				success: function(result) {
					alert('success!');
					console.log(result);
				},
				error: function(result) {
					alert('error!');
					console.log(result);
				}
				
			});
			
		});
		
		
	});
		
</script>
</head>
<body>
	<h2>상품리스트</h2>
	<select id="findKey">
		<option value="itemcode">상품코드</option>
		<option value="itemname">상품명</option>
	</select>
	<input type="text" id="findValue">
	<button id="btnList">조회</button>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>상품코드</th>
			<th>상품명</th>
			<th>가격</th>
			<th>비고</th>
		</tr>
		<c:forEach var="item" items="${list}" varStatus="status"> 
			<tr>
				<td>${status.count}</td>
				<td>%{item.itemcode}</td>
				<td>%{item.itemname}</td>
				<td>%{item.price}</td>
				<td>%{item.bigo}</td>
			</tr>
		</c:forEach>
</body>
</html>