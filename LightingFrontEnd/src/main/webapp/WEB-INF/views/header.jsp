 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<title>The Lights Wagon</title>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
	
	<script>
var app = angular.module('myApp', []);
 
function MyController($scope, $http) {

	 $scope.sortType = 'name'; // set the default sort type
	  $scope.sortReverse = false;  // set the default sort order
	  $scope.searchPTitle = '';
	  
        $scope.getDataFromServer = function() {
                $http({
                        method : 'GET',
                        url : 'GsonCon'
                }).success(function(data, status, headers, config) {
                        $scope.sup = data;  
                }).error(function(data, status, headers, config) {
                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                });
        };
        
};

	</script>
		
<style>
#tb {
    border: 2px solid #3CB371;
    border-radius: 20px;
}
#product {
    width: 700px;
    height: 850px;
    margin: 100px auto 50px auto;
    padding: 20px;
    position: relative;
    border: 5px solid #3CB371;
    border-radius: 20px;  
}
#category {
    width: 700px;
    height: 300px;
    margin: 100px auto 50px auto;
    padding: 20px;
    position: relative;
    border: 5px solid #3CB371;
    border-radius: 20px;  
}

#signin {
    width: 350px;
    height: 350px;
    margin: 100px auto 50px auto;
    padding: 20px;
    position: relative;
    border: 5px solid #3CB371;
    border-radius: 20px;  
}

#signup {
    width: 420px;
    height: 420px;
    margin: 100px auto 50px auto;
    padding: 20px;
    position: relative;
    border: 5px solid #3CB371;
    border-radius: 20px;  
}


body{ padding-left:20px;
padding-right:20px;
padding-top:50px;}
a:hover {background-color: #00008B;
color:#00FFFF}
.navbar .nav > li > a:hover { 
background-color: #00008B;
color:#00FFFF
}
.navbar .nav > li{
color:#00FFFF;
font-family:Verdana;
}
.navbar .nav > ul > a{
color:#00FFFF;
font-weight: bold;
font-family:Verdana;
}

.navbar .nav > li > a{
color:#00FFFF;
font-weight: bold;
font-family:Verdana;
}
.navbar .navbar-brand{
font-size: 20px;
font-style: oblique;
font-weight: bold;
color: #00688B;
}
.dropdown-menu > li > a:hover {
    background-color: #90EE90;
    background-image: none;
}
a.button {
  display: inline-block;
  border-radius: 50%;
  background-color: #3CB371;
  border: 4px solid #00FF7F;
  color: #FFFFFF;
  text-align: center;
  font-size: 20px;
  padding: 20px;
  width: 250px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}
a.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}
a.button span:after {
  content: '»';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

a.button:hover span {
  padding-right: 25px;
}

a.button:hover span:after {
  opacity: 1;
  right: 0;
}
#buttons {
background: #3CB371;
color: #fff;
border: 1px solid #00FF7F;
border-radius: 20px;
width:150px;
padding: 10px;
box-shadow: 5px 5px 5px #eee;
transition-duration: 0.4s;
text-decoration: none;
overflow: hidden;
cursor: pointer;
}

input#button {
background: #3CB371;
color: #fff;
border: 1px solid #00FF7F;
border-radius: 20px;
width:150px;
padding: 10px;
box-shadow: 5px 5px 5px #eee;
transition-duration: 0.4s;
text-decoration: none;
overflow: hidden;
cursor: pointer;
}

input#button:after {
content: "";
    background: #f1f1f1;
    display: block;
    position: absolute;
    padding-top: 300%;
    padding-left: 350%;
    margin-left: -20px !important;
    margin-top: -120%;
    opacity: 0;
    transition: all 0.8s
}

input#button:after {
    padding: 0;
    margin: 0;
    opacity: 1;
    transition: 0s
}

.error {
        color: red; font-weight: bold;
}

</style>

</head>
<body>

	<nav class="navbar navbar-fixed-top" style="background-color: #3CB371;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="#" class="navbar-brand">THE LIGHTS WAGON</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="home">Home</a></li>
					<li><a href="aboutus">About Us</a></li>
					<li><a href="contactus">Contact Us</a></li>
				</ul>
				
				 <ul class="nav navbar-nav navbar-right">
    <c:choose><c:when test="${empty loggedInUser}">
    <li><a href="signin">Sign In </a></li>
    <li><a href="memberShip.obj">Sign Up</a></li></c:when>
    <c:when test="${not empty loggedInUser}">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">My Profile <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <li><a href="#">My Account</a></li>
        <li><a href="#">My Orders</a></li>
        <li><a href="#">Settings</a></li>
        <li><a href="perform_logout">Sign Out</a></li>        
       </ul>
       </li>
       <li><c:if test="${not empty cartSize}">
 R      <a href="viewcart${loggedInUserID}"><span class="glyphicon glyphicon-shopping-cart">Cart</span></a>(${cartSize})</c:if></li>
       <li><c:if test="${empty cartSize}">
       <a href="viewcart${loggedInUserID}"><span class="glyphicon glyphicon-shopping-cart">Cart</span></a></c:if></li></c:when>
       </c:choose>
     
    </ul>   
    </div>   
   <!--  </div> -->
<br>
				<!-- <div class="container-fluid"> -->
				<div>
    <ul class="nav navbar-nav navbar-left">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:forEach var="catname" items="${categoryList}">

            <li><a href="images">${catname.cat_name}</a></li>

        </c:forEach>
        </ul>
       </li>
       <li>
    <a href="productsuser">Products</a>    </li>
    
    
     <li class="form">
   <form class = "bs-example bs-example-form" role = "form">
      
 <div class = "col-sm-4">
            <div class = "input-group">
               <input type = "text" class = "form-control">
               
               <span class = "input-group-btn">
                  <button class = "btn btn-default" type = "button">
                     Go!
                  </button>
               </span>
               
            </div><!-- /input-group -->
         </div><!-- /.col-lg-6 -->
         
      
   </form>
   </li>
    
      </ul>     
      
      
      
  <ul class="nav navbar-nav navbar-right">
    <c:if test="${not empty loggedInUser}">
    <li class="navbar-text" style="font-size:150%;">Welcome ${loggedInUser}!</li></c:if>
    <c:if test="${loggedout==true}">
    <li class="navbar-text" style="font-size:150%;">${logOutMessage}!</li></c:if>
   
 </ul>
 </div>
 </div>
 </nav>
 
 