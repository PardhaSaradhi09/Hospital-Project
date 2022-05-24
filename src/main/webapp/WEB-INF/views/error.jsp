<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manuh Hospital/Error</title>
<link rel="stylesheet" type="text/css" href="/css/menuStyle.css">
</head>
<body>
<div class="main header">
	<h1>Manuh Hospital</h1>
	<p><c:out value="${username}"/></p>
	
	<h3 class="error"><c:out value="${adding}"></c:out></h3>
</div>
<div class="logout">
	<a href="/ManuhHospital/LogOutServlet">
 	<button type="submit"> logout </button>
 	</a>
 	</div>
 <div class="container">
 	<div class="header">
 		<h1>error</h1>
 	</div>
 	  <h3><c:out value=" ${error} please check the url"></c:out></h3>
 	  <h3 class="error"><c:out value="${emptyResult}"></c:out></h3>
 	   <h3 class="error"><c:out value="${NumberFormatException}"></c:out></h3>
 	    <h3 class="error"><c:out value="${date}"></c:out></h3>
 	  <h3><c:out value=" ${deleteError}"></c:out></h3>
 	<div class="main">
 	<button  type="button" onclick="Previous()">back</button>
 	</div>
 </div>
 <script  >function Previous() {
     window.history.back()
 }</script>
</body>
</html>