<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty list }">
 구매이력이 없습니다.
</c:if>
<c:if test="${not empty list }">
<table border="1">
<tr><th>num</th><th>m_id</th><th>p_num</th><th>quantity</th><th>address</th><th>tel</th><th>o_date</th><th>cost</th><th>state</th>
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
	<td>${ p.state }</td>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>