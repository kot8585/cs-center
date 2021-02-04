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
<a href="${ pageContext.request.contextPath }/member/loginForm">로그인</a>
<a href="${ pageContext.request.contextPath }/member/joinForm">회원가입</a>
<a href="${ pageContext.request.contextPath }/mypage/mypage">마이페이지</a>
<a href="${ pageContext.request.contextPath }/board/list">고객센터</a>

<c:import url="${ pageContext.request.contextPath }/product/list"></c:import>
</body>
</html>