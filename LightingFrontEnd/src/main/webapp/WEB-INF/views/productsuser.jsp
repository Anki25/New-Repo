 <%@ include file="header.jsp" %>
 
 <br/><br/><br/><br/><br/><br/><br/><br/>
 
     <c:if test="${!empty productList}"> 	
  <table>
     <c:forEach items="${productList}" var="product" varStatus="rowCounter"	>
     <div class="container-fluid"> <div class="col-md-3">
     <c:if test="${rowCounter.count % 4 == 1}">
      <tr>
    </c:if>
				<td style="padding-right: 20px;padding-left: 20px">
				<div class="thumbnail">
				<img src="resources/images/${product.pro_Id}.jpg" class="img-rounded" style="width:300px;height:300px">
				<p style="float:left">${product.pro_name}</p>
				<p style="float:right"><i class="fa fa-inr" aria-hidden="true"></i> ${product.price}</p><br />
				<p style="text-align:center;"><a href="viewProduct?pro_Id=${product.pro_Id}" id="buttons" class="btn btn-success" style="font-size: 12px;">View</a></p></div></td>
				
				<c:if test="${rowCounter.count % 4 == 0}">
      </tr>
    </c:if>
			 </div></div>
			</c:forEach>     
     
  
</table>

 </c:if>  
 
 <%@ include file="footer.jsp" %>