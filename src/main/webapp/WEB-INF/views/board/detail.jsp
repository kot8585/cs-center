<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	var str = "";
	$(document).ready(function(){

		$("#edit").click(function(){
			var result = confirm("글을 삭제하시겠습니까?");
			if(result){
				location.href = "${pageContext.request.contextPath}/board/del?num=${b.num}";
			}
		});
		
		$("#repWrite").click(function(){
			$.post("${pageContext.request.contextPath}/rep/write",
					{
						board_num : ${b.num},
						text : $("#rep_title").val(),
						content : $("#rep_content").val()
					})
			.done(function(data){
				var items = eval("(" + data + ")");
				//var items = eval( data );
				//for(i=0;i<items.length;i++){
		    	//	str+=items[i].content+"(작성자:"+items[i].writer+")<br>";
		    	//}
				str+=items.content+"(작성자:"+items.writer+")<br>";

		    	$("#reply").html(str);
			});
		});
	});
</script>
</head>
<body>

	<c:if test="${sessionScope.id ne b.writer }">
		<c:set var="data" value="readonly" />
	</c:if>
	<form action="${pageContext.request.contextPath }/board/edit" method="post">
		<table border="1" cellspacing="0">
		
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${b.writer}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${b.title}" ${data}></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" value="${b.content}" ${data}></td>
			</tr>
			<tr>
				<td>작성날짜</td>
				<td><input type="text" name="b_date" value="${b.b_date}"></td>
			
			</tr>
			<table border="1">
			<c:if test="${not empty file0 }">
				<tr>
					<td>이미지</td>
					<td><img src="${pageContext.request.contextPath }/board/img?fname=${file0}&num=${b.num}" class="img" width="50" height="50"></td>
					<td><img src="${pageContext.request.contextPath }/board/img?fname=${file1}&num=${b.num}" class="img" width="50" height="50"></td>
					<td><img src="${pageContext.request.contextPath }/board/img?fname=${file2}&num=${b.num}" class="img" width="50" height="50"></td>
				</tr>
			</c:if>
			</table>
		</table>
			<input type="hidden" name="num" value="${b.num}">
			<input type="hidden" name="pwd" value="${b.pwd}">
			
			<!-- 작성자만 수정, 삭제 버튼 뜨게 하기 -->
			<c:if test="${sessionScope.id eq b.writer}">
				<input type="submit" value="수정하기">
				<input type="button" value="삭제하기" id="edit">
			</c:if>
			
			<!-- 관리자는 삭제버튼만 뜨게 하기 -->
			<c:if test="${sessionScope.id eq 'admin'}">
				<input type="button" value="삭제하기" id="edit">
			</c:if>
	</form>
	<!-- 관리자 페이지일경우에만 뜸 -->	
	<form action="" method="post">
		<table border="1">
			<tr>
				<td>작성자 : <input type="text" id="rep_title"></td>
			</tr>
			<tr>
				<td>내용 : <textarea id="rep_content"></textarea></td>
			</tr>
			<tr>
				<td><input type="button" id="repWrite" value="작성" ></td>
			</tr>
		</table>
	</form>
	
	<!-- 댓글 작성되면 이 영역에 넣는다 -->
	<div id="reply"></div>
	
	<!-- 댓글경우 출력하기 -->
		<table border="1">
	<c:forEach var="r" items="${b.reps }">
			<tr><td>작성자: <input type="text" value="${r.writer}"></td></tr>
			<tr><td>내용 : <textarea rows="5" cols="40">${r.content}</textarea></td></tr>
	</c:forEach>
		</table>
</body>
</html>