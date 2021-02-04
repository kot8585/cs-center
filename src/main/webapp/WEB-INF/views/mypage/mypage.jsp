<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>마이페이지</title>
</head>
<body>
<a href="${ pageContext.request.contextPath }/member/main">메인으로</a>
<a href="${ pageContext.request.contextPath }/member/editForm">내정보수정</a>
<a href="${ pageContext.request.contextPath }/mypage/myOrderForm">주문내역</a>
<a href="${ pageContext.request.contextPath }/mypage/myQuestionForm">문의내역</a>
<a href="${ pageContext.request.contextPath }/mypage/shoppingcartForm">장바구니</a>
<a href="${ pageContext.request.contextPath }/member/logout">로그아웃</a>
<a href="${ pageContext.request.contextPath }/member/out">탈퇴</a>
</body>
</html>