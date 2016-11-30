<%@ include file="header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

<br/><br/><br/>
<center>
<springForm:form id="product" action="registerP" method="post" commandName="prod" enctype="multipart/form-data">

<h3 style="color:#3CB371;font-weight:bold;">Manage Product</h3>

${message}
		<table class="table table-hover" style="width:650px;">
			<tr>
				<td ><spring:message text="Enter Product Id:" /></td>
				<c:choose>
					<c:when test="${!empty product.pro_Id}">
						<td><springForm:input path="pro_Id" disable="true"
								readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td ><springForm:input path="pro_Id" pattern=".{4,7}" required="true" title="id should contain 4 to 7 characters" /></td>
						<td><springForm:errors path="pro_Id" cssClass="error"/></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td ><spring:message text="Enter Product Name:"/></td>
				<td><springForm:input type="text" path="pro_name" /></td>
				<td><springForm:errors path="pro_name" cssClass="error"/></td>
			</tr>
			<tr>
				<td ><spring:message text="Enter Product Code:"/></td>
				<td><springForm:input type="text" path="prod_ID" /></td>
				<td><springForm:errors path="prod_ID" cssClass="error"/></td>
			</tr>
			<tr>
				<td ><spring:message text="Enter Company Name:"/></td>
				<td><springForm:input type="text" path="comp_name" /></td>
				<td><springForm:errors path="comp_name" cssClass="error"/></td>
			</tr>
			<tr>
				<td ><spring:message text="Description:"/></td>
				<td><springForm:textarea path="description" rows="5" cols="30" /></td>
				<td><springForm:errors path="description" cssClass="error"/></td>
			</tr>
			<tr>
				<td ><spring:message text="Price:"/></td>
				<td><i class="fa fa-inr" aria-hidden="true"></i><form:input type="text" path="price" /></td>
				<td><springForm:errors path="price" cssClass="error"/></td>
			</tr>
			<tr>
				<td ><spring:message text="Quantity:"/></td>
				<td><springForm:input type="text" path="quantity" /></td>
				<td><springForm:errors path="quantity" cssClass="error"/></td>
			</tr>
			<tr>
				<td ><springForm:label path="supplier">
						<spring:message text="Supplier:" />
					</springForm:label></td>
				<td><springForm:select path="supplier.sup_name" items="${supplierList}"
						itemValue="sup_name" itemLabel="sup_name"></springForm:select></td>
			</tr>

			<tr>
				<td ><form:label path="category">
						<spring:message text="Category:" />
					</form:label></td>
				<td><springForm:select path="category.cat_name" items="${categoryList}"
						itemValue="cat_name" itemLabel="cat_name"></springForm:select></td>
			</tr>
			<tr>
				<td ><spring:message text="Image:"/></td>
				<td><springForm:input type="File" path="image" /></td>
				<td><springForm:input type="File" path="img" /></td>
			</tr>
			</table>
			<center>
				<c:if test="${!empty product.pro_name}">
						<input id="button" type="submit" value="<spring:message text="Edit Product"/>" />
					</c:if>
					<c:if test="${empty product.pro_name}">
						<input id="button" type="submit" value="<spring:message text="Add Product"/>" />
					</c:if>
			</center>
		
	</springForm:form>

	<br>
	<h3 style="color:#3CB371;font-weight:bold;">Product List</h3>
	<c:if test="${!empty productList}">
		<table id="tb" class="table table-hover"">
			<tr>
				<th>Product Id</th>
				<th>Product Code</th>
				<th>Product Name</th>
				<th>Company Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Category</th>
				<th>Supplier</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.pro_Id}</td>
					<td>${product.prod_ID}</td>
					<td>${product.pro_name}</td>
					<td>${product.comp_name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td>${product.quantity}</td>
					<td>${product.category.cat_id}</td>
					<td>${product.supplier.sup_id}</td>
					<td><a href="<c:url value='product/edit/${product.pro_Id}' />">Edit</a></td>
					<td><a
						href="<c:url value='product/remove/${product.pro_Id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</center>


<%@ include file="footer.jsp"%>
