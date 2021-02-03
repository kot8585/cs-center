<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function go() {
	var id = document.getElementById("id");
	var password = document.getElementById("password");
	
	if(id.value == ""){
		alert("아이디 또는 비밀번호가0 액션빔")
		return
	}
	if(password.value == ""){
		alert("아이디 또는 비밀번호가 액션빔")
	}else{
		f.submit()
	}
}	
</script>
</head>
<body>
<form name="f" method="POST" action="${pageContext.request.contextPath }/member/login">
	<table border="1">
		<tr>
			<th>ID</th>
			<td><input type="text" name="id" id="id"></td>
		</tr>
		<tr>
			<th>PWD</th>
			<td><input type="password" name="password" id="password"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="로그인" onclick="go()" id="passwordCheck" ></td>
		</tr>
	</table>
</form>
<a href="${pageContext.request.contextPath }/member/findForm">ID/PWD 찾기</a>
</body>
</html>