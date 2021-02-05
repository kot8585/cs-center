<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/member/edit">
<table border="1">
<tr>
<td>ID</td>
<td><input type="text" name="id" value="${m.id }" readonly></td>
</tr>
<tr>
<td>PWD</td>
<td><input type="text" name="password" value="${m.password }"></td>
</tr>
<tr>
<td>NAME</td>
<td><input type="text" name="name" value="${m.name }"></td>
</tr>
<tr>
<td>BIRTH</td>
<td><input type="date" name="birth" value="${m.birth }"></td>
</tr>
<tr>
<td>GENDER</td>
<td colspan="2">
<input type="radio" name="gender" value="m">남자
<input type="radio" name="gender" value="f">여자</td>
</tr>
<tr>
<td>ADDRESS</td>
<td><input type="text" name="address" value="${m.address }"></td>
</tr>
<tr>
<td>TEL</td>
<td><input type="text" name="tel" value="${m.tel }"></td>
</tr>
<tr>
<td>EMAIL</td>
<td><input type="text" name="email" value="${m.email }"></td>
</tr>
<tr>
<td colspan=""><input type="submit" value="수정">
<input type="reset" type="재입력"></td>
</tr>
</table>
</form>
</body>
</html>