<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>주문정보</h3>
<table border="1" cellspacing="0">
	<tr>
		<th>제품명</th><th>주문수량</th><th>가격</th><th>결제금액</th>
	</tr>
	<tr>
		<td>${ order.p.name }</td><td>${ order.quantity }</td><td>${ order.p.price }</td><td>${ order.quantity * order.p.price }</td>
	</tr>
</table>
<form action="${ pageContext.request.contextPath }/order/order" method="post">
배송지 주소 : <input type="text" name="address" value="${ order.m.address }"><br>
받을 사람 전화번호 : <input type="text" name="tel" value="${ order.m.tel }"><br>
<input type="submit" value="결제">
<input type="hidden" name="m_id" value="${ sessionScope.id }">
<input type="hidden" name="p_num" value="${ order.p_num }">
<input type="hidden" name="quantity" value="${ order.quantity }">
<input type="hidden" name="cost" value="${ order.quantity * order.p.price  }">
<input type="hidden" name="state" value="0">
</form>
</body>
</html>