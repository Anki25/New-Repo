<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Lights Wagon</title>
</head>
<body>
<h1>Access is denied!</h1>
<c:choose>
<c:when test="${empty username}">
<h3>You do not have permission to access this page!</h3>
</c:when>
<c:otherwise>
<h3>Sorry ${name} <br/>You do not have permission to access this page!</h3>
</c:otherwise>
</c:choose>
</body>
</html>