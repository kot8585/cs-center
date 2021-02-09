<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>

</script>
</head>
<body>

	<form action="${pageContext.request.contextPath }/board/edit" method="post">
		<table border="1" cellspacing="0">
		
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${b.writer}" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${b.title}" ${data} readonly></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content"  rows="15" cols="40" readonly>${b.content}</textarea></td>
			</tr>
			<tr>
				<td>작성날짜</td>
				<td><input type="text" name="updatedate" value="${b.updatedate}" readonly></td>
			</tr>
		
		
		</table>
			<input type="hidden" name="num" value="${b.num}">
			
	</form>
<hr>
	

</body>
</html>