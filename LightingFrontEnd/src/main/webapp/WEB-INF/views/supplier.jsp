 <%@ include file="header.jsp" %> 
 
 <br/><br/><br/><br/><br/>
   					
	<center>
	<c:url var="addAction" value="/supplier/add"></c:url>
	<form:form id="category" action="${addAction}" commandName="supplier">
	<h3 style="color:#3CB371;font-weight:bold;">Manage Supplier</h3>
	<table class="table table-hover">
	<tr><td>
	<form:label path="sup_id"><spring:message text="Supplier ID"/></form:label></td>
	<td><form:input path="sup_id" required="true"/></td></tr>
	<tr><td>
	<form:label path="sup_name"><spring:message text="Name"/></form:label></td>
	<td><form:input path="sup_name" required="true"/></td></tr>
	<tr><td><form:label path="address"><spring:message text="Address"/></form:label></td>
	<td><form:input path="address" required="true"/></td>
	</tr>
	</table>
	<center>
	<c:if test="${!empty supplier.sup_name}">
	<input id="button" type="submit" value="<spring:message text="Edit Supplier"/>" />
	</c:if><c:if test="${empty supplier.sup_name}">
	<input id="button" type="submit" value="<spring:message text="Add Supplier"/>" />
	</c:if>
	</center>
	
	</form:form>
	
	
	 
	 <div class="container" ng-app="myApp" ng-controller="MyController" ng-init="getDataFromServer()">
	 
	 <h3 style="color:#3CB371;font-weight:bold;align:center">Supplier List</h3>
	 
	  <table id="tb" class="table table-hover">
             
      <tr>
      <th>Supplier Id</th>
	<th>Supplier Name</th>
	<th>Address</th>
	<th>Edit</th>
	<th>Delete</th>
  </tr>
  <tr ng-repeat="s1 in sup">
      <td>{{s1.sup_id}}</td>
      <td>{{s1.sup_name}}</td>
      <td>{{s1.address}}</td>
           		
       <td><a href="supplier/edit/{{s1.sup_id}}">Edit</a></td>
       <td><a href="supplier/delete/{{s1.sup_id}}">Delete</td>
   
           	
      </tr>
  
	 </table>
	 </div>

	 
	 </center>
<%@ include file="footer.jsp" %>