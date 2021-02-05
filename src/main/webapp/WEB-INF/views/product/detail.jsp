<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
   $(document).ready(function() {
      $(".img").mouseover(function() {
         $("#bigImg").attr('src', this.src);
      });
   });
</script>
</head>
<body>
<h3>상품 상제 정보</h3>


<table border="1" cellspacing="0">
<tr>
<th>번호</th>
<td><input type="text" name="num" value="${p.num }">
</td>
</tr>

<tr>
<th>상품명</th>
<td><input type="text" name="name" value="${p.name }">
</td>
</tr>

<tr>
         <th>이미지</th>
         <td><c:if test="${empty file0 }">
               등록된 이미지가 없습니다.
               </c:if> 
               <c:if test="${not empty file0 }">
               <table>
                  <tr>
                     <td colspan="3">
                     <img id="bigImg" src="${pageContext.request.contextPath }/img?fname=${file0 }&num=${p.num }" 
                     style="width:150px;height:150px"></td>
                  </tr>
                  <tr>
                     <td><img src="${pageContext.request.contextPath }/img?fname=${file0 }&num=${p.num }" class="img" width="50" height="50"></td>
                     <td><img src="${pageContext.request.contextPath }/img?fname=${file1 }&num=${p.num }" class="img" width="50" height="50"></td>
                     <td><img src="${pageContext.request.contextPath }/img?fname=${file2 }&num=${p.num }" class="img" width="50" height="50"></td>
               </table>
            </c:if></td>
      </tr>
      

<tr>
<th>메이커</th>
<td><input type="text" name="maker" value="${p.maker }">
</td>
</tr>

<tr>
<th>가격</th>
<td><input type="text" name="price" value="${p.price }">
</td>
</tr>

<tr>
<th>원산지</th>
<td><input type="text" name="origin" value="${p.origin }">
</td>
</tr>

<tr>
<th>재료</th>
<td><input type="text" name="material" value="${p.material }">
</td>
</tr>

<tr>
<th>수량</th>
<td><input type="text" name="quantity" value="${p.quantity }"></td>
</tr>

<tr>
<td colspan="2">
<input type="submit" value="수정">
<input type="button" value="삭제" id="del">
</td>
</tr>

</table>
<a href="${pageContext.request.contextPath }/review/reviewForm">리뷰 작성</a>
</body>
</html>