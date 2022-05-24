<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Manuh Hospital/Sorted Patient List</title>

<link rel="stylesheet" type="text/css" href="./css/GetAllPAtientsCss.css">
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
		<a href="menu">
			<button type="submit">Back To Menu</button>
		</a>
	</div>
	<div class="container">
		<div class="header">
			<h2 class="sub">All Doctor Records<br>(Shorted List by age)</h2>
		</div>
		<div class="main">
			<table name="dataTable">
				<thead>
					<tr>
						<th>Patient Id</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>gender</th>
						<th>Age</th>
						<th>phone number</th>
						<th>address</th>
						<th>Date Of Join</th>
						<th>Date Of Discharge</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${sortedpatientList}" var="doctor">
        <tr>
        <td><c:out value="${doctor.did}" /></td>
          <td><c:out value="${doctor.DName}" /></td>
          <td><c:out value="${doctor.DGender}" /></td>
          <td><c:out value="${doctor.DAge}" /></td>
          <td><c:out value="${doctor.DAddress}" /></td>
          <td><c:out value="${doctor.designation}" /></td>
          <td><c:out value="${doctor.DPhn}" /></td>
          <td><c:out value="${doctor.pid}" /></td>
           <td><a href="EditDoctorServlet?did=<c:out value="${doctor.did}" />"><button><i class="fas fa-edit"></i></button></a>
								
							</td>
						<td><a href="DeleteDoctorServlet?did=<c:out value="${doctor.did}" />"><button name="deleteButton" onclick="return confirm('Are you sure you want to delete patient ')">
								<i class="fas fa-trash-alt"></i>
							</button>
							</a></td>
        </tr>
      </c:forEach>
					

				</tbody>
				</div>
				<br>
			<!-- 	<script type="text/javascript" src="./js/GetAllPatientsJs.js"></script> -->
</body>
</html>