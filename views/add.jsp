<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
<script type="text/javascript">
	//document가 준비 가 된후 
	$(function(){
		$('#btnAdd').click(function() {
			const itemcode = $('#itemcode').val();
			const itemname = $('#itemname').val();
			const price = $('#price').val();
			const bigo = $('#bigo').val();
			console.log(itemcode);
			console.log(itemname);
			console.log(price);
			console.log(bigo);
			if (itemcode==''){
				alert('상품코드를 등록해 주세요');
				$('#itemcode').focus();
				return ;
			}else if (itemname==''){
				alert('상품명를 등록해 주세요');
				$('#itemname').focus();
				return ;
			}else if (price==''){
				alert('가격을 등록해 주세요');
				$('#price').focus();
				return ;
			}

			//ajax(비동기식) 서버로 데이터 전송
			//'application/json' 형식으로 전송
			$.ajax({
				type: 'post', //보낼데이터의 method
				contentType:'application/json',//json형태로 데이터 서버로 보냄
				url:'/item/item/', //매핑url
//				data: JSON.stringify({itemcode:itemcode,itemname:itemname,price:price,bigo:bigo}), //json문자열 표기법
				data: JSON.stringify({itemcode,itemname,price,bigo}), //json문자열 표기법
				dataType: 'text', //받을데이터의 형식
				success: function(result) { //성공시 실행할 함수
					alert(result);
					$('#msg').text(result);
					$(location).attr('href', '/item/item/list');
				},
				error: function(result) { //실패시 실행할 함수
					alert('error');
					console.log(result);
				}
			});
		
			//application/x-www-form-urlencoded
/* 			$.ajax({
				type: 'post', //보낼데이터의 method
				url:'/item/item/', //매핑url
				data: {itemcode:itemcode,itemname:itemname,price:price,bigo:bigo}, //json문자열 표기법
				dataType: 'text', //받을데이터의 형식
				success: function(result) { //성공시 실행할 함수
					alert(result);
					$('#msg').text(result);
				},
				error: function(result) { //실패시 실행할 함수
					alert('error');
					console.log(result);
				}
			}); */

		});
	});
</script>
</head>
<body>
	
	<h2>상품등록</h2>
	상품코드 : <input type="text" id="itemcode"><br>
	상품명 : <input type="text" id="itemname"><br>
	단가 : <input type="number" id="price"><br>
	비고 : <input type="text" id="bigo"><br>
	<button id="btnAdd">등록</button>
	<div id ="msg">
	</div>
</body>
</html>