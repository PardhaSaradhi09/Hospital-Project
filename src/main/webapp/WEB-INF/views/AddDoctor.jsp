<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Manuh Hospital/Add Doctor Data</title>
<link rel="stylesheet" type="text/css" href="/css/DoctorDatacss.css">

</head>
<body>
	<div class="main header">
		<h1>Manuh Hospital</h1>
	</div>
	<div class="logout">
	<a href="<c:url value='/ManuhHospital/menu'/>">
 	<button type="submit"> Back To Menu </button>
 	</a>
 	</div>
	<div class="container">
		<div>
			<h3 class="header">Enter New Doctor Data</h3>
		</div>
		<div class="main">
			<form:form action="/ManuhHospital/AddDoctor" method="post"
				modelAttribute="doctorRecord">
				 <%@ include file="AddDoctorform.jsp" %> 
				<form:hidden path="pid" placeholder="phone number" value="${pid}" />
				<form:button>Submit</form:button>

			</form:form>
			<a href="<c:url value='/ManuhHospital/GetDoctorRecords'/>">
				<button type="submit">Cancel</button>
			</a>

		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="AddDoctorJS.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"
		integrity="sha512-37T7leoNS06R80c8Ulq7cdCDU5MNQBwlYoy1TX/WUsLFC2eYNqtKlV0QjH7r8JpG/S0GUMZwebnVFLPd6SU5yg=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>

































