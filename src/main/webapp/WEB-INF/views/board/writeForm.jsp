<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Board Register</h1>
	<form action="${pageContext.request.contextPath }/board/write" method="post"  enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>작성자</th><td><input type="text" name="writer" value="${sessionScope.id }"></td>
			</tr>
			<tr>
				<th>제목</th><td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th><td><textarea rows="10" cols="33" ></textarea></td>
			</tr>
			<tr>
				<th>작성자</th><td><input type="text" name="writer" value="${sessionScope.id }"></td>
			</tr>
			<tr>
				<th>파일첨부1</th><td><input type="file" name="file1"></td>
				<th>파일첨부2</th><td><input type="file" name="file2"></td>
				<th>파일첨부3</th><td><input type="file" name="file3"></td>
			</tr>
			<tr><td><input type="reset" value="취소">	</td>
			<td><input type="submit" value="등록"></td></tr>
		</table>
	</form>
</body>
</html>