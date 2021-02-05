<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="${pageContext.request.contextPath }/member/join">
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
			<th>Name</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>Birth</th>
			<td><input type="date" name="birth"></td>
		</tr>
		<tr>
			<th>Gender</th>
			<td><input type="radio" name="gender" value="m">남
			<input type="radio" name="gender" value="f">여</td>
		</tr>
		<tr>
			<th>Address</th>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<th>Tel</th>
			<td><input type="text" name="tel"></td>
		</tr>
		<tr>
			<th>Email</th>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td><input type="submit"></td>
		</tr>
		
		
	</table>
</form>
</body>
</html>