<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Manuh Hospital/login</title>
	
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<div class="main header">
	<h1>MANUH HOSPITAL</h1>
</div>
 <div class="container">
 	<div class="header">
 		<h1>login</h1>
 		<p  class="sub">Only admin and staff can access to login</p>
 		<p class="error"><c:out value="${error}" /></p>
 		<p class="error"><c:out value="${loginError}"></c:out></p>
 		<p class="error"><c:out value="${logOutError}"></c:out></p>
 		<!--  <p class="error"><%=request.getAttribute("error")
		%></p>-->
 	</div>
 	<div class="main">
 		<form   id="form" onsubmit="return validateForm()" action="/ManuhHospital/LogInServlet" method="post" >
			<input  type="text" placeholder="Username" id="Username" name="username">
			<input  type="password"  placeholder="Password" id="password" name="password">
 			<br>
 			
 			<button type="submit"> login</button>

 		</form>
 	</div>
 </div> 
 <!--  <script type="text/javascript" src="demoJs.js"></script> -->
</body>
</html>