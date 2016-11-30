  <%@ include file="header.jsp" %>
  
  <br/><br/><br/><br/><br/><br/><br/>
  
 <div class="container">
 <h1 style="font-weight:bold;font-size: 400%;">${product.pro_name}</h1>
	<div class="row">
		<div class="col-md-4">
		<div id="myCarousel" class="carousel slide" >
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="resources/images/${product.pro_Id}.jpg" class="img-rounded" style="width:350px;height:300px">
    </div>

    <div class="item">
      <img src="resources/images/${product.prod_ID}.jpg" class="img-rounded" style="width:350px;height:300px">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
		</div>
				
				
			<div class="col-md-8">	
				
				<p style="font-weight:bold;font-size: 250%;"><i class="fa fa-inr" aria-hidden="true"></i>${product.price}</p><br />
				<p>Brand: ${product.comp_name}</p>
				<p>Sold By: ${product.supplier.sup_name}</p><br/>
				<p>Product Description: ${product.description }</p><br/>
			
			
				<form method="POST" action="buy${loggedInUserID}&${product.pro_Id}">
                Quantity:<input type="number" name="quantity" value=1 style="width:33px"/><br>
                <input type="submit" value="Buy" class="btn btn-warning shadow" style="font-size:19px;margin:30px 30px"/>
                </form>


		<%-- 		<a href="buy${loggedInUserID}&${product.pro_Id}" id="buttons" class="btn btn-success">Add to Cart</a>&nbsp;&nbsp;&nbsp;
		 --%>		
		</div>
		</div>
		</div>
		
  <br /><br />
  <%@ include file="footer.jsp" %>