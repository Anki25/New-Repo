<%@ include file="header.jsp" %>
<br/><br/><br/><br/><br/><br/><br/>
<center>


<a href="${flowExecutionUrl}&_eventId_home">Home</a>

<form:form commandName="sa" id="saddress">

  <h3 style="color:#3CB371;font-weight:bold;">Shipping Address</h3><br/>
  <p>Please enter your shipping details..</p>
  
<table>
<tr style="padding: 20px"><td>
Street Address: </td><td><form:input type="text" path="address" /></td></tr>
 <!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 

<tr style="padding: 20px"><td>
City: </td><td><form:input type="text" path="city"  /></td></tr>
<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('city')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 

<tr style="padding: 20px"><td>
Pincode: </td><td><form:input type="text" path="pincode"  /></td></tr>
<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('pincode')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 




</table>
<div class="center">
Payment mode: <br/>
card payment<input type="radio" name="payment" CHECKED>
netbanking<input type="radio" name="payment" >
cash on delivery<input type="radio" name="payment" >



<br /><br />


<input id="button" type="submit" name="_eventId_submit" value="Proceed" ></div>

</form:form>
</center>
<%@ include file="footer.jsp" %>