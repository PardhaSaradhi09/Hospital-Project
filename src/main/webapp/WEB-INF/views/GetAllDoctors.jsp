<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Manuh Hospital/All Doctors</title>

<link rel="stylesheet" type="text/css" href="/css/GetAllPAtientsCss.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<div class="main header">
		<h1>MANUH HOSPITAL</h1>
	</div>
	</div>

	<div class="logout">
		<a href="/ManuhHospital/menu">
			<button type="submit">Back To Menu</button>
		</a>
	</div>
	<div class="container">
		<div class="header">
			<h2 class="sub">All Doctors Records</h2>
		</div>
		<div class="main">
			<table name="dataTable">
				<thead>
					<tr>
						<th>Doctor Id</th>
						<th>Doctor Name</th>
						<th>gender</th>
						<th>Age</th>
						<th>address</th>
						<th>Designation</th>
						<th>phone number</th>
						<th>Patient Id</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${doctorList}" var="entry">
				
        <tr>
        <td><c:out value="${entry.did}" /></td>
          <td><c:out value="${entry.DName}" /></td>
          <td><c:out value="${entry.DGender}" /></td>
          <td><c:out value="${entry.DAge}" /></td>
          <td><c:out value="${entry.DAddress}" /></td>
          <td><c:out value="${entry.designation}" /></td>
          <td><c:out value="${entry.DPhn}" /></td>
          <td><c:out value="${entry.pid}" /></td>
          <td><a href="EditDoctor/<c:out value="${entry.did}" />"><button><i class="fas fa-edit"></i></button></a>
								
							</td>
						<td><a href="DeleteDoctorData?did=<c:out value="${entry.did}" />"><button name="deleteButton" onclick="return confirm('Are you sure you want to delete doctor record ')">
								<i class="fas fa-trash-alt"></i>
							</button>
							</a></td>
        </tr>
      </c:forEach>
				</tbody>
				</div>
				
				<br>
				<p class="errors"><c:out value="${inValidDid}"></c:out></p>
				<form action="SearchDoctor">
				<input type="number" placeholder="Enter Doctor Id " name="did">
				<button class="logout" type="submit">Search</button>
				</form>
				<a href="<c:url value='/ManuhHospital/GetAllPatientRecordsPage'/>">
					<button type="submit" class="logout">Add New Doctor Data</button>
				</a>
				</table>
			<!-- 	<script type="text/javascript" src="./js/GetAllPatientsJs.js"></script> -->
</body>
</html>