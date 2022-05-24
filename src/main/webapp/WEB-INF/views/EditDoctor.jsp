<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Manuh Hospital/Update Doctor Data</title>
<link rel="stylesheet" type="text/css" href="/css/DoctorDatacss.css">

</head>
<body>
	<div class="main header">
		<h1>Manuh Hospital</h1>
	</div>
	<div class="container">
		<div>
			<h3 class="header">Update Doctor Data</h3>
		</div>
		<div class="main">
			<form:form action="/ManuhHospital/EditDoctor" method="post"
				modelAttribute="doctorRecord">
				 <form:hidden path="did" />
				<form:errors path="DName" cssClass="errors"></form:errors><br>
				<form:input path="DName" placeholder="Name*" /><br>
				<form:errors path="DGender" cssClass="errors"></form:errors><br>
				<form:select path="DGender"  >
					<form:option value="">Select</form:option>
					<form:option value="M">Male</form:option>
					<form:option value="F">Female</form:option>
				</form:select><br>
				<form:errors path="DAge" cssClass="errors"></form:errors><br>
				<form:input path="DAge" placeholder="Age*" /><br>
				<form:errors path="DAddress" cssClass="errors"></form:errors><br>
				<form:input path="DAddress" placeholder="city"  /><br>
				<form:errors path="Designation" cssClass="errors"></form:errors><br>
				<form:input path="Designation" placeholder="Designation" /><br>
				<form:errors path="DPhn" cssClass="errors"></form:errors><br>
				<form:input path="DPhn" placeholder="phone number"  /><br>
				<form:hidden path="pid" placeholder="phone number" />
				<form:button>Submit</form:button>

			</form:form>
			<a href="<c:url value='/ManuhHospital/GetDoctorRecords'/>">
				<button type="submit">Cancel</button>
			</a>

		</div>
	</div>
	
</body>
</html>

































