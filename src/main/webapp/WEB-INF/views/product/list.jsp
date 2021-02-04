<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js">
   
</script>
</head>
<body>

   <h3>상품리스트</h3>
   <table border="1" cellspacing="0">
      <thead>
         <tr>
            <th>번호</th>
            <th>이미지</th>
            <th>이름</th>
            <th>메이커</th>
            <th>가격</th>
            <th>원산지</th>
            <th>재료</th>
            <th>수량</th>
         </tr>
      </thead>
      <c:forEach var="p" items="${list}">
         <tr>
            <td>${p.num}</td>
            <td><img id="bigImg" src="${pageContext.request.contextPath }/product/img?fname=${file0 }&num=${p.num}" style="width:60px;height:60px"></td>
            <td><a href="${pageContext.request.contextPath }/product/detail?num=${p.num}">${p.name}</a></td>
            <td>${p.maker}</td>
            <td>${p.price}</td>
            <td>${p.origin}</td>
            <td>${p.material}</td>
            <td>${p.quantity}</td>            
         </tr>
      </c:forEach>
   </table>
</body>
</html>