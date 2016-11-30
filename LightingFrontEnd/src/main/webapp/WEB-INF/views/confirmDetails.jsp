<%@ include file="header.jsp" %>

<div class="content" align="center">

		<fieldset>
			
			<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
			<a href="${flowExecutionUrl}&_eventId_home">Home</a><br /> <br />
			<form:form modelAttribute="us" id="signup">
			
			<h3 style="color:#3CB371;font-weight:bold;">Confirm Details</h3>
			
				<form:label path="userID">User ID :</form:label>${us.userID}
					<br />
				<br />
				<form:label path="name"> User Name:</form:label>${us.name}
					<br />
				<br />
				<form:label path="password">Password :</form:label>${us.password}
					<br />
                    <br />

				<form:label path="emailid">Email:</form:label>${us.emailid}
					<br />
				<br />
				<form:label path="mobileno">Mobile #:</form:label>${us.mobileno}
					<br />
				<br />
				<form:label path="address">Address :</form:label>${us.address}
					<br />
				<br />
				<input id="button" name="_eventId_edit" type="submit" value="Go Back" />
				<input id="button" name="_eventId_submit" type="submit" value="Register me" />
				<br />
			</form:form>
		</fieldset>
		
	</div>


<%@ include file="footer.jsp" %>