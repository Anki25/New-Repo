 <%@ include file="header.jsp" %>
 
   <div class="container" ng-app="myApp" ng-controller="MyController" ng-init="getDataFromServer()">
   <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
       <input type="text" class="form-control" placeholder="Search Product Name" ng-model="searchPTitle">      
       </div>      
    </div>
  </form>
  
   <table class="table table-bordered table-striped">
             
    <thead>
      <tr>
      <td>
          <a href="#" ng-click="sortType = 'id'; sortReverse = !sortReverse">
            Product Id 
            <span ng-show="sortType == 'id' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'id' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        
        <td>
          <a href="#" ng-click="sortType = 'productname'; sortReverse = !sortReverse">
            Product Name 
            <span ng-show="sortType == 'productname' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'productname' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'quantity'; sortReverse = !sortReverse">
          Quantity
            <span ng-show="sortType == 'quantity' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'quantity' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'price'; sortReverse = !sortReverse">
          Price
            <span ng-show="sortType == 'price' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'price' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'more'; sortReverse = !sortReverse">
          More
            <span ng-show="sortType == 'more' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'more' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         <td>
          <a href="#" ng-click="sortType = 'more'; sortReverse = !sortReverse">
          Image
            <span ng-show="sortType == 'more' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'more' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        
        </tr>
    </thead>
    
    <tbody>
      <tr ng-repeat="p1 in prod | orderBy:sortType:sortReverse | filter:searchPTitle">
      <td>{{p1.pro_Id}}</td>
           		<td>{{p1.pro_name}}</td>
      
           		
           		<td>{{p1.quantity}}</td>
           		<td>{{p1.price}}</td>
           		<td><a href="viewProduct?pro_Id={{p1.pro_Id}}">View</a></td>
           		<td><img src="resources/images/{{ p1.pro_Id}}.jpg" style="width:100px;height:100px"></td>
   
           	
      </tr>
    </tbody>
    
  </table>
  
</div>

    
    <%@ include file="footer.jsp" %>