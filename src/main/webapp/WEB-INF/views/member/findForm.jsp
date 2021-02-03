<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ID/PWD 찾기 Page</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(document).ready(function(){
	$("#find").click(function(){
		alert("clicked");
		$.post("/member/find", {email: $("#email").val(), name: $("#name").val()})
		.done(function(data){
			$("#findId").text(data);
			
		})
	})
})
	
</script>
</head>
<body>
<h3>ID/PWD 찾기</h3>
<p>회원가입 시 입력한 E-mail주소와 이름을 입력해주세요.
<form>
	<table border="1">
		<tr>
			<th>EMAIL</th>
			<td><input type="text" name="email" id="email"></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><input type="text" name="name"id="name"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" id="find" value="find"></td>
		</tr>
	</table>
</form>
<div id="findId"></div>
</body>
</html>