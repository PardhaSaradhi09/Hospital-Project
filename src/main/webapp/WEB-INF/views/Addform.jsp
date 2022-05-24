<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


			
				
				<p class="error"><c:out value="${emptyFieldError }"></c:out></p>
				<p class="errors" path="firstName"></p>
				<input type="hidden"  placeholder="Patient Id*" name="pid" value='<c:out value="${patient.pid}" />'> 
				<!--  <p class="error"><c:out value="${emptyFliedError.get(fnameError) }"></c:out></p>-->
				<input path="firstName" placeholder="first name*" name="firstName" pattern="[A-Za-z ]+" title="only alphabets and space are acceptble"value='<c:out value="${patient.firstName}" />'>
				 <!-- <p class="error"><c:out value="${emptyFliedError.get(lnameError) }"></c:out></p> -->
				 <input placeholder="last name" name="lastName" value='<c:out value="${patient.lastName}" />'><br> 
				  <!-- <p class="error"><c:out value="${emptyFliedError.get(genderError) }"></c:out></p>-->
				 <label >Select Gender:</label> 
				 <select name="gender" value='<c:out value="${patient.gender}" />'>
				 	<option value="">Select</option>
					<option value="M">Male</option>
					<option value="F">Female</option>
					<option value="O">Others</option>
				</select> 
				
				<input type="number" placeholder="Age*" name="age" value='<c:out value="${patient.age}" />'> 
				<!--  <p class="error"><c:out value="${emptyFliedError.get(ageError) }"></c:out></p> -->
				<input type="number" placeholder="phone number" name="phn" value='<c:out value="${patient.phn}" />'> 
				<!--  <p class="error"><c:out value="${emptyFliedError.get(phoneNumberError) }"></c:out></p> -->
				<input type="text" placeholder="city" name="address" value='<c:out value="${patient.address}" />'> 
				<!--  <p class="error"><c:out value="${emptyFliedError.get(dojError) }"></c:out></p> -->
				<input type="text" placeholder="Date of join" name="dateOfJoin" value='<c:out value="${patient.dateOfJoin}" />'> 
				<!--  <p class="error"><c:out value="${emptyFliedError.get(dodError) }"></c:out></p> -->
				<input type="text" placeholder="Date of discharge" name="dateOfDischarge" value='<c:out value="${patient.dateOfDischarge}" />'>  <br>
				

		

