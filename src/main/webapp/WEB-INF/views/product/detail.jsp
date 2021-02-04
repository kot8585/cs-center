<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
// 수정 삭제의 경우 admin 페이지에서 넘어가도록.
$(document).ready(function() {
	$(".img").mouseover(function() {
		$("#bigImg").attr('src', this.src);
	});
	
	$("#cart").click(function() {
		var m_id = $("#m_id").val();
		var p_num = $("#p_num").val();
		var cost = $("#cost").val();
		alert(m_id + " + " + p_num + " + " + cost);
		$.post("/cart/addCart", { m_id: m_id, p_num: p_num, cost: cost })
		.done(function(data) {
			// 중복 불가능하게 하는건 다음번에 잡자.
			alert("장바구니에 추가되었습니다!");
		});
	});
	
});	
</script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h5>세션 id : ${ sessionScope.id }</h5>
<h3>상품 상세 정보</h3>
<form action="${ pageContext.request.contextPath }/order/orderForm" method="post">
<table border="1" cellspacing="0">
<tr>
<th>번호</th>
<td><input type="text" name="p_num" id="p_num" value="${p.num }" readonly="readonly">
</td>
</tr>
<tr>
	<th>상품이미지</th>
	<td><c:if test="${empty file0 }">
					등록된 이미지가 없습니다.
					</c:if> 
					<c:if test="${not empty file0 }">
					<table>
						<tr>
							<td colspan="3">
							<img id="bigImg" src="${pageContext.request.contextPath }/product/img?fname=${file0 }&num=${p.num }" 
							style="width:150px;height:150px"></td>
						</tr>
						<tr>
							<td><img src="${pageContext.request.contextPath }/product/img?fname=${file0 }&num=${p.num }" class="img" width="50" height="50"></td>
							<td><img src="${pageContext.request.contextPath }/product/img?fname=${file1 }&num=${p.num }" class="img" width="50" height="50"></td>
							<td><img src="${pageContext.request.contextPath }/product/img?fname=${file2 }&num=${p.num }" class="img" width="50" height="50"></td>
					</table>
				</c:if></td>
<tr>

<tr>
<th>상품명</th>
<td><input type="text" value="${p.name }" readonly="readonly">
</td>
</tr>

<tr>
<th>메이커</th>
<td><input type="text" value="${p.maker }" readonly="readonly">
</td>
</tr>

<tr>
<th>가격</th>
<td><input type="text" id="cost" value="${p.price }" readonly="readonly">
</td>
</tr>

<tr>
<th>원산지</th>
<td><input type="text" value="${p.origin }" readonly="readonly">
</td>
</tr>

<tr>
<th>재료</th>
<td><input type="text" value="${p.material }" readonly="readonly">
</td>
</tr>

<tr>
<th>남는수량</th>
<td><input type="text" value="${p.quantity }" readonly="readonly"></td>
</tr>

<tr>
<th>주문수량</th>
<td><input type="text" name="quantity"></td>
</tr>



<tr>
<td colspan="2">
	<input type="hidden" name="m_id" id="m_id" value="${ sessionScope.id }"><input type="submit" value="구매">
	<input type="button" value="장바구니로" id="cart">
</td>
</tr>
</table>

</form>
</body>
</html>