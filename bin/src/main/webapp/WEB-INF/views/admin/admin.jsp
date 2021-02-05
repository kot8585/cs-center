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

<hr>
<h3>전체 구매 이력</h3>
<c:import url="${ pageContext.request.contextPath }/admin/orderList"></c:import>
<hr>
</body>
</html>