<%@ include file="header.jsp" %>

<br/><br/><br/><br/><br/><br/><br/>

	<c:if test="${!empty cartList}">
	<h3 style="font-weight:bold;font-size: 200%;">My Cart</h3>
		<table class="tb">
			<c:forEach items="${cartList}" var="cart">
				<tr style="padding-bottom:20px;padding-top:20px">
				    <td style="padding-right: 20px;padding-left: 20px;"><img src="resources/images/${cart.product.pro_Id}.jpg" class="img-rounded" style="width:50px;height:50px"></td>
					<td style="padding-right: 20px;padding-left: 20px;"><p style="font-weight:bold;font-size: 150%;">${cart.product.pro_name}</p> by ${cart.product.comp_name}</td>
					<td style="padding-right: 20px;padding-left: 20px"><i class="fa fa-inr" aria-hidden="true"></i> ${cart.price}</td>
					<td style="padding-right: 20px;padding-left: 20px">Quantity: ${cart.quantity}</td>
					<td style="padding-right: 20px;padding-left: 20px"><a href="cartitemdelete${cart.cartId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<p>Total price: ${cartprice}</p>
		<a href="checkOut.obj" id="buttons" style="float:right;">Checkout</a>
	</c:if>

<c:if test="${empty cartList}">

<h3 style="font-weight:bold;font-size: 200%;">Oops!!!</h3><br/>

<h2>Your Shopping Cart seems empty!</h2><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

</c:if>

<br/><br/><br/><br/><br/>

<%@ include file="footer.jsp" %>