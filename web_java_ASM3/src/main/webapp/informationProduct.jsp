<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<img id="imgProduct" alt="hinh anh" src=" ${tinh2.product_img}" />
</div>
<div>
    <p> ${tinh2.product_type}</p>
	<p> ${tinh2.product_name}</p>
	<p> ${tinh2.product_price}</p>
</div>	
<form action="AddToCart" method="get">
  <input type="text" name="idAddToCart" value="${tinh2.product_id}" style="display: none;">
  <input type="submit" value="Add To Cart">
</form>				
	
</body>
</html>