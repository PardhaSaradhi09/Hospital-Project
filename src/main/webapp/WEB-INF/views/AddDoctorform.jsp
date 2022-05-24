<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


				<form:hidden path="did" />
				<form:errors path="DName" cssClass="errors"></form:errors><br>
				<form:input path="DName" placeholder="Name*" value="${doctor.DName}"/><br>
				<form:errors path="DGender" cssClass="errors"></form:errors><br>
				<form:select path="DGender">
					<form:option value="">Select</form:option>
					<form:option value="M">Male</form:option>
					<form:option value="F">Female</form:option>
				</form:select><br>
				<form:errors path="DAge" cssClass="errors"></form:errors><br>
				<form:input path="DAge" placeholder="Age*" /><br>
				<form:errors path="DAddress" cssClass="errors"></form:errors><br>
				<form:input path="DAddress" placeholder="city" /><br>
				<form:errors path="Designation" cssClass="errors"></form:errors><br>
				<form:input path="Designation" placeholder="Designation" /><br>
				<form:errors path="DPhn" cssClass="errors"></form:errors><br>
				<form:input path="DPhn" placeholder="phone number" /><br>
				
			

































