<%@ include file="header.jsp" %>

<center>


<a href="${flowExecutionUrl}&_eventId_home">Home</a>
<form:form commandName="us" id="signup">
  <h3 style="color:#3CB371;font-weight:bold;">Sign Up</h3><br/>
  <p>ALREADY REGISTERED? <a href= "signin">SIGN IN</a></p>
<table>
<tr style="padding: 20px"><td>
Name</td><td><form:input type="text" path="name" /></td></tr>
 <!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('name')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 

<tr style="padding: 20px"><td>
Choose a User Name</td><td><form:input type="text" path="userID"  /></td></tr>
<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('userID')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
<tr style="padding: 20px"><td>
Enter Password</td><td><form:input type="password" path="password"  /></td></tr>
<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 

<tr style="padding: 20px"><td>
Enter Confirmed Password</td><td><form:input type="password" path="cpassword"  /></td></tr>
<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('cpassword')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 

<tr style="padding: 20px"><td>
Email Id</td><td><form:input type="email" path="emailid" /></td></tr>
<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('emailid')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 

				

<tr style="padding: 20px"><td>
Phone no.</td><td><form:input type="text" path="mobileno" /></td></tr>
<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('mobileno')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 


<tr style="padding: 20px"><td>
City</td><td> <form:input type="text" path="address" /></td></tr>

<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 

</table>
<div class="center">

<input type="CHECKBOX" NAME="OFFER" CHECKED>I agree to receive information about exciting offers



<br /><br />


<input id="button" type="submit" name="_eventId_submit" value="I'm done" ></div>

</form:form>
</center>
<%@ include file="footer.jsp" %>