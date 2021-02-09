<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	 $("#oHistory").
	});
</script>
</head>
<body>

<h1>1:1문의하기</h1>
	<form action="${pageContext.request.contextPath }/board/write" method="post"  enctype="multipart/form-data">
		
		<!-- 질문 카테고리 -->
		<select name="q_cate" id="q_cate">
			<option value="">-- 문의유형을 선택해주세요 --</option>
			<option value="order">주문 상품 문의</option>
			<option value="p_delivery">배송 관련 문의</option>
			<option value="system">시스템 개선 의견</option>
		</select>
		
		<!-- 주문 내역 o -->
		<select name="oHistory" id="oHistory">
			<option value="">--주문내역을 선택해주세요--</option>
			
		</select>
		
		<!-- 문의 폼 -->
		<table border="1">
			<tr>
				<th>제목</th><td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>비밀번호</th><td><input type="password" name="pwd" ></td>
			</tr>
			
			<tr>
				<th>내용</th><td><textarea name="content" rows="10" cols="33" ></textarea></td>
			</tr>

			<tr>
				<th>파일첨부1</th><td><input type="file" name="file1"></td>
			</tr>
			<tr>
				<th>파일첨부2</th><td><input type="file" name="file2"></td>
			</tr>
			<tr>
				<th>파일첨부3</th><td><input type="file" name="file3"></td>
			</tr>
			
			<tr><td><input type="reset" value="취소"></td>
			<td><input type="submit" value="등록"></td></tr>
		</table>
		<input type="hidden" name="path" value="123"> 
		<input type="hidden" name="writer" value="${sessionScope.id }" >
	</form>
</body>
</html>
