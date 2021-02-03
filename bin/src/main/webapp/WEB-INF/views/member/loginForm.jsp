<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="${pageContext.request.contextPath }/member/login">
	<table border="1">
		<tr>
			<th>ID</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>PWD</th>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>
</form>
<a href="${pageContext.request.contextPath }/member/findForm">ID/PWD 찾기</a>
</body>
</html>