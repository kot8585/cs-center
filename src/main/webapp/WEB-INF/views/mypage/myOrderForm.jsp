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
 등록된 상품이 없다. 
</c:if>
<c:if test="${not empty list }">
<table border="1">
<tr><th>주문번호</th><th>주문자ID</th><th>제품번호</th><th>가격</th><th>날짜</th><th>배송상태</th>
<c:forEach var="p" items="${list }">
<tr>
	<td>${ p.num }</td>
	<td><a href="${ pageContext.request.contextPath }/product/detail?num=${p.num}">${ p.m_id }</a></td>
	<td>${ p.p_num }</td>
	<td>${ p.cost }</td>
	<td>${ p.o_date }</td>
	<td>${ p.state }</td>
	<td><input type="button" value="리뷰작성"></td>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>