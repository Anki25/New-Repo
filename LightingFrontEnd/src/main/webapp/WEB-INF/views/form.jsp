<h1>Add a Category</h1>
	
	<form action="/newcategory/add">
	<table class="table table-hover">
	<tr><td>
	Category ID</td><td><input type="text" required="true" /></td>
	</tr>
	<tr><td>
	Name</td>
	<td><input type="text" required="true" /></td></tr>
	<tr><td>Description></td>
	<td><input type="text" required="true"/></td>
	</tr>
	<tr>
	<td>
	<input id="button" type="submit" value="Add Category" /></td>
	</tr>
	</table>
	</form>
	<br>
	<h3>Category List</h3>
	<c:if test="${!empty categoryList}">
	<table class="tg">
	<tr>
	<th width="80">Category Id</th>
	<th width="120">Category Name</th>
	<th width="120">Description</th>
	<th width="60">Edit</th>
	<th width="60">Delete</th>
	</tr>
	<c:forEach items="${categoryList}" var="cat">
	<tr>
	<td>${cat.cat_id}</td>
	<td>${cat.cat_name}</td>
	<td>${cat.description}</td>
	<td><a href="<c:url value='category/edit/${cat.cat_id}' />">Edit</a></td>
	<td><a href="<c:url value='category/remove/${cat.cat_id}' />">Delete</a></td>
	</tr>
	</c:forEach>
	</table>
	</c:if>
	<br>
