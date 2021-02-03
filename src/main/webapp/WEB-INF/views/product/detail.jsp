<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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

</body>
</html>