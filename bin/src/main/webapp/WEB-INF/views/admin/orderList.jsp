<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty list }">
 구매이력이 없습니다.
</c:if>
<c:if test="${not empty list }">
<table border="1">
<tr><th>num</th><th>m_id</th><th>p_num</th>
<th>quantity</th><th>address</th><th>tel</th>
<th>o_date</th><th>cost</th><th>state</th>
<th>주문상태변경</th>
<c:forEach var="p" items="${list }">
<tr>
	<td>${ p.num }</td>
	<td>${ p.m_id }</td>
	<td>${ p.p_num }</td>
	<td>${ p.quantity }</td>
	<td>${ p.address }</td>
	<td>${ p.tel }</td>
	<td>${ p.o_date }</td>
	<td>${ p.cost }</td>
	<td>
		<c:choose>
			<c:when test="${ p.state == 0 }">준비중</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${ p.state == 1 }">배송중</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${ p.state == 2 }">배송완료</c:when>
		</c:choose>
	</td>
	<td><input type="button" value="주문상태변경" id="stateBtn"></td>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>