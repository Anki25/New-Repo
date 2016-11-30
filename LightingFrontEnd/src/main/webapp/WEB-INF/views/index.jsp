<html>

<body>
<h2>Hello World!</h2>

 ${message} <br> 

<a href="signin">Sign in</a> <br>
<a href="signup">Sign up</a> <br>


<c:if test="${userClickedSignIn}==true">
<jsp:include page="signup.jsp"></jsp:include>
</c:if>

<c:if test="${userClickedSignUp}==true">
<jsp:include page="signin.jsp"></jsp:include>
</c:if>



</body>
</html>
