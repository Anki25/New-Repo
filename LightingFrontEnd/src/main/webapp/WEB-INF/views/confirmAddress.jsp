<%@ include file="header.jsp" %>
<br/><br/><br/><br/><br/><br/><br/>
<div class="content" align="center">

		<fieldset>
			
			<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
			<a href="${flowExecutionUrl}&_eventId_home">Home</a><br /> <br />
			<form:form modelAttribute="sa" id="saddress">
			
			<h3 style="color:#3CB371;font-weight:bold;">Confirm Details</h3>
			
				<form:label path="address">Address :</form:label>${sa.address}
					<br />
				<br />
				<form:label path="city">City: </form:label>${sa.city}
					<br />
				<br />
				<form:label path="pincode">Pincode :</form:label>${sa.pincode}
					<br />
                    <br />

				<input id="button" name="_eventId_edit" type="submit" value="Go Back" />
				<input id="button" name="_eventId_submit" type="submit" value="Submit" />
				<br />
			</form:form>
		</fieldset>
		
	</div>


<%@ include file="footer.jsp" %>