<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>

<a href="${ pageContext.request.contextPath }/member/editForm">내정보수정</a>
<a href="${ pageContext.request.contextPath }/mypage/myOrderForm">주문내역</a>
<a href="${ pageContext.request.contextPath }/mypage/myQuestionForm">문의내역</a>
<a href="${ pageContext.request.contextPath }/mypage/shoppingcartForm">장바구니</a>

<a href="${ pageContext.request.contextPath }/member/logout">로그아웃</a>
<a href="${ pageContext.request.contextPath }/member/out">퇴탈</a>

</body>
</html>