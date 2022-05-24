<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Manuh Hospital/Doctor with ID</title>

<link rel="stylesheet" type="text/css"
	href="/css/GetAllPAtientsCss.css">
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
		<a href="<c:url value='/ManuhHospital/menu'/>">
			<button type="submit">Back To Menu</button>
		</a>
	</div>
	<div class="container">
		<div class="header">
			<h2 class="sub">Doctor Record</h2>
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
						<tr>
							<td><c:out value="${searchDoctor.did}" /></td>
							<td><c:out value="${searchDoctor.DName}" /></td>
							<td><c:out value="${searchDoctor.DGender}" /></td>
							<td><c:out value="${searchDoctor.DAge}" /></td>
							<td><c:out value="${searchDoctor.DAddress}" /></td>
							<td><c:out value="${searchDoctor.designation}" /></td>
							<td><c:out value="${searchDoctor.DPhn}" /></td>
							<td><c:out value="${searchDoctor.pid}" /></td>
							<td><a href="EditDoctor/<c:out value="${searchDoctor.did}" />"><button><i class="fas fa-edit"></i></button></a>
								
							</td>
						<td><a href="DeleteDoctorData?did=<c:out value="${searchDoctor.did}" />"><button name="deleteButton" onclick="return confirm('Are you sure you want to delete doctor record ')">
								<i class="fas fa-trash-alt"></i>
							</button>
							</a></td>
						</tr>
			
				</tbody>
			</table>
</div>
</div>
</body>
</html>