<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Manuh Hospital/Edit/Update Patient Data</title>
<link rel="stylesheet" type="text/css" href="/css/Addpatientcss.css">
</head>
<body>
	<div class="main header">
		<h1>Manuh Hospital</h1>
	</div>
	<div class="logout">
	<a href="<c:url value='/ManuhHospital/menu'/>">
 	<button type="submit"> Back to Menu </button>
 	</a>
 	</div>
	<div class="container">
		<div>
			<h3 class="header">Edit/Update Patient Data</h3>
		</div>
		<div class="main" >
			<form name="form" onsubmit="return validateForm()" action="/ManuhHospital/UpdatingPatientRecord" method="post">
			
				<%@ include file="Addform.jsp" %>  
				<button type="submit" name="add">Update Patient Data</button>

			</form>
			<a href="<c:url value='/ManuhHospital/GetAllPatientRecordsPage'/>">
			<button type="submit">Cancel</button>
			</a>
		</div>
	</div>
	
	<!--  <script type="text/javascript" src="./js/AddPatient.js"></script>
	<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>-->
</body>
</html>