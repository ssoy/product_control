<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<script type="text/javascript" src="/item/resources/js/jquery-3.5.1.js"></script>
<!-- 핸들바 탬플릿 cdn추가 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
 <!-- 탬플릿 소스2 -->
 <script id="template_source" type="text/x-handlebars-template">
        <table border="1">
            <tr>
                <th>상품코드</th>
                <th>상품명</th>
                <th>단가</th>
                <th>비고</th>
                <th>등록일자</th>
            </tr>
            {{#each.}}
                <tr>
                    <td><a href='/item/item/{{itemcode}}'>{{itemcode}}</a></td>
                    <td>{{itemname}}</td>
                    <td>{{price}}</td>
                    <td>{{bigo}}</td>
                    <td>{{regdate}}</td>
                </tr>
            {{/each}}
        </table>
</script>
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
					//alert('success!');
					console.log(result);
					//태플릿을 이용하여 화면에 출력
					var source = $('#template_source').html();
		            var template = Handlebars.compile(source);
		            $('div').html(template(result));
				},
				error: function(result) {
					alert('error!');
					console.log(result);
				}
				
			});
			
		});
		
		//등록
		$('#btnAdd').click(function() {
			$(location).attr('href','/item/item/');
		});
		
		
		$('#btnList').trigger('click');	//강제로 click이벤트 발생
		
		
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
	<button id="btnAdd">등록</button>
	
	<div>
	</div>
	
</body>
</html>