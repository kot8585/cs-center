<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>

	
	function del(){
		location.href="/review/delReview";
		
	}
</script>
</head>
<body>
<form name="f" method="POST" action="${pageContext.request.contextPath }/review/editReview">
   <table border="1" cellspacing="0">
      <thead>
         <tr>
            <th>번호</th>
            <td><input type="text" name="num" value="${r.num}" readonly></td>
         </tr>
           <tr>
            <th>상품번호</th>
            <td><input type="text" name="pnum" value="${r.pnum}" readonly></td>
         </tr>
           <tr>
            <th>제목</th>
            <td><input type="text" name="title" value="${r.title }"></td>
         </tr>
           <tr>
            <th>작성자</th>
            <td>${r.writer}</td>
         </tr>
           <tr>
            <th>내용</th>
            <td><input type="text" name="content" value="${r.content}"></td>
         </tr>
           <tr>
            <th>작성날짜</th>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${r.pdate}" /></td>
         </tr>
         <tr>
         	<td colspan="2">
         		<input type="submit" value="수정">
         		<input type="button" value="삭제" onclick="del()">
         	</td>
         </tr>
          
      </thead>
     
    
     
   </table>
   </form>
</body>
</html>