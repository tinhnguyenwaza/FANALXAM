<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color: yellow;}
</style>

<script>
function validateForm() {
  let name = document.forms["myForm"]["customerName"].value;
  let address = document.forms["myForm"]["customerAddress"].value;
  let dCode = document.forms["myForm"]["discountCode"].value;
  if (name == "" || address == "" || dCode == "") {
    alert("Không được bỏ trống thông tin");
    return false;
  }
}
</script>

</head>
<body>
<table>
  <tr>
    <th>Product in Cart ${Cart.getLenghtList() }</th>
    <th>Price</th>
    <th>QuaLyti</th>
    <th>Amount</th>
  </tr>
  <c:forEach items="${Cart.getListCart()}" var="a">
  <tr>
    <td>${a.product_name}</td>
    <td>${a.product_price}</td>
    <td>${a.product_number}</td>
    <td>${a.product_price * a.product_number}</td>
  </tr>
  </c:forEach>
  <tr>
  <td></td>
   <td></td>
   <td>Tatol Mony</td>
  <td>${Cart.getAmount()}</td>  
  </tr>
</table>

<!-- From lấy thông tin custumer -->
<form name="myForm" action="submitOrder" onsubmit="return validateForm()" method="get">
  Customer name : <input type="text" name="customerName"><br>
  Customer address: <input type="text" name="customerAddress"><br>
  Discount code(if any): <input type="text" name="discountCode"><br>   
  <input type="submit" value="Submit">
</form>

</body>
</html>