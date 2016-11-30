 <%@ include file="header.jsp" %> 
 <br/><br/><br/><br/><br/>
 
   		<center>			
	<c:url var="addAction" value="/category/add"></c:url>
	<form:form id="category" action="${addAction}" commandName="category">
	<h3 style="color:#3CB371;font-weight:bold;">Manage Category</h3>
	
	<table class="table table-hover">
	<tr><td>
	<form:label path="cat_id"><spring:message text="Category ID"/></form:label></td>
	<td><form:input path="cat_id" disabled="true" readonly="true" value="${cat.cat_id}"/></td>
	
	</tr>
	<tr><td>
	<form:label path="cat_name"><spring:message text="Name"/></form:label></td>
	<c:choose>
	<c:when test="${!empty cat.cat_name}">
	<td><form:input path="cat_name" required="true" value="${cat.cat_name}" /></td>
	</c:when>
	<c:otherwise>
	<td><form:input path="cat_name" required="true"/></td>
	</c:otherwise>
	</c:choose></tr>
	<tr><td><form:label path="description"><spring:message text="Description"/></form:label></td>
	<c:choose>
	<c:when test="${!empty cat.description}">
	<td><form:input path="description" required="true" value="${cat.description}"/></td>
	</c:when>
	<c:otherwise>
	<td><form:input path="description" required="true"/></td>
	</c:otherwise>
	</c:choose></tr>
	</table>
	<center>
	<c:if test="${!empty cat.cat_id}">
	<input id="button" type="submit" formaction="category/edit" value="<spring:message text="Edit Category"/>" />
	</c:if><c:if test="${empty cat.cat_id}">
	<input id="button" type="submit" value="<spring:message text="Add Category"/>" />
	</c:if>
	</center>
	
	</form:form>
	<br>
	<h3 style="color:#3CB371;font-weight:bold;align:center">Category List</h3>
	<c:if test="${!empty categoryList}">
	<table id="tb" class="table table-hover">
	<tr>
	<th >Category Id</th>
	<th >Category Name</th>
	<th >Description</th>
	<th >Edit</th>
	<th >Delete</th>
	</tr>
	<c:forEach items="${categoryList}" var="category">
	<tr>
	<td>${category.cat_id}</td>
	<td>${category.cat_name}</td>
	<td>${category.description}</td>
	<td><a href="<c:url value='category/edit/${category.cat_id}' />">Edit</a></td>
	<td><a href="<c:url value='category/remove/${category.cat_id}' />">Delete</a></td>
	</tr>
	</c:forEach>
	</table>
	</c:if>
	</center>
	<br>
 <%@ include file="footer.jsp" %>