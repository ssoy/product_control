<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
<script type="text/javascript" src="/item/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(function() {
		//수정
		$('#btnModify').on('click', function() {
			const itemcode = $('#itemcode').val();
			const itemname = $('#itemname').val();
			const price = $('#price').val();
			const bigo = $('#bigo').val();
			console.log(itemcode);
			console.log(itemname);
			console.log(price);
			console.log(bigo);
			
			if (itemname==''){
				alert('상품명을 입력해주세요');
				$('#itemcode').focus();
				return ;
			}else if (price==''){
				alert('단가를 입력해주세요');
				$('#price').focus();
				return ;				
			}
			
			//ajax
			$.ajax({
				type: "put", //수정
				contentType: "application/json", //json형태로 데이터 서버에 보냄, put방식지원하기 위해서 
				url: '/item/item/'+itemcode, 
				data : JSON.stringify({itemcode,itemname,price,bigo}), //보낼데이터
				dataType:'text', //받을데이터의 타입
				success: function(result) {
					alert(result);
					$(location).attr('href', '/item/item/list');
				},
				error: function(result) {
					alert('error');
					console.log(result);
				}
			}); //ajax의 끝
		}); //수정함수의 끝
		
		//삭제함수
		$('#btnRemove').on('click', function() {
			var result = confirm('삭제하시겠습니까?');
			if (!result) return ;
			
			const itemcode = $('#itemcode').val();
			console.log(itemcode);
			
			$.ajax({
				type:'delete',
				url: '/item/item/'+itemcode,
				dataType: 'text',
				success : function(result) {
					alert(result);
					//리스트로 이동
					$(location).attr('href', '/item/item/list');
				},
				error : function() {
					alert('error');
					console.log(result);
				}
			});
		});
		
		
	});

</script>
</head>
<body>
	<h2>수정</h2>
	상품코드:<input type="text" id="itemcode" value="${dto.itemcode}" readonly> <br>
	상품명:<input type="text" id="itemname" value="${dto.itemname}"><br>
	단가:<input type="text" id="price" value="${dto.price}"><br>
	비고:<input type="text" id="bigo" value="${dto.bigo}"><br>
	<button id="btnModify">수정</button>
	<button id="btnRemove">삭제</button>
</body>
</html>