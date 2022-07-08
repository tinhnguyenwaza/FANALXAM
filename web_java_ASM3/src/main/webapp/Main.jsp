<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<div class="row">
	 <c:forEach items="${List}" var="a">
	
		<div class="col-md-4">
		 <a href="informationProductController?idProduct1=${a.product_id}">
			<div class="informationProduct">
			
				<img id="imgProduct" alt="hinh anh" src=" ${a.product_img}" />
				<p> ${a.product_type}</p>
				<p> ${a.product_name}</p>
				<p> ${a.product_price}</p>
			</div>
			</a>
			
		
		</div>
		
	</c:forEach>
		<!-- end pháº§n information product -->

		<!--  start pháº§n shopping cart -->
		<div class="col-md-2">
			<div>
				<h4>cart</h4>
			</div>

			<!--  Popular product  -->
			<div>
				<h4>img</h4>
				<h4>img</h4>
				<h4>img</h4>
			</div>

		</div>


	</div>


</div>