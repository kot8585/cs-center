<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
var sessionId = '<%=session.getAttribute("id") %>'

   $(document).ready(function(){ //로그인 되어있는지 확인하기
      $("#write").click(function(){
         if(sessionId == '' || sessionId == null){
         alert("로그인 후에 이용할 수 있습니다.");
         location.href= "${pageContext.request.contextPath }/member/loginForm";
      } else {
         //로그인 안되어있을시
         location.href="${pageContext.request.contextPath }/board/writeForm";
      }});
   });
</script>
</head>
<body>
	
	<h3></h3>
	<table border="1" cellspacing="0">
		<thead>
			<tr>
				<th>이름</th>
				<th>메이커</th>
				<th>가격</th>
				<th>원산지</th>
				<th>재료</th>
				<th>수량</th>
				</tr>
		</thead>
		<c:forEach var="b" items="${list}">
			<tr>
				<td><c:out value="${p.num}" /></td>
				<td><c:out value="${p.name}" /></td>
				<td><c:out value="${p.price}" /></td>
				<td><c:out value="${p.origin}" /></td>
				<td><c:out value="${p.material}" /></td>
				<td><c:out value="${p.quantty}" /></td>				
			</tr>
		</c:forEach>
	</table>

	세션아이디 : <c:out value="${sessionScope.id}" />
<input type="button" id ="write" value="글쓰기">
	
	

	
</body>
</html>