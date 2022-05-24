<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Manuh Hospital/Menu</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" type="text/css" href="/css/menuStyle.css">
</head>
<body>
<div class="main header">
	<h1>Manuh Hospital</h1>
	<p><c:out value="${username}"/></p>
</div>
<div class="logout">
	<a href="LogOutServlet">
 	<button type="submit"> logout </button>
 	</a>
 	</div>
 <div class="container">
 	<div class="header">
 		<h1>MENU</h1>
 	</div>
 	<div class="main">
 		<div class="dropdown">
 		
  			<button class="dropbtn" >Patient Services</button>
  			<div class="dropdown-content">
    				<a href="<c:url value='/ManuhHospital/AddPatientDataPage'/>">Add New Patient Data</a>
    				<a href="<c:url value='/ManuhHospital/GetAllPatientRecordsPage'/>">Get All Patients Records</a>
    				<!--  <a href="#">Get Patient Data By PID</a>
    				<a href="#">Sort By Patient Age  </a>-->
  			</div>
			</div>
 		<div class="dropdown">
  			<button class="dropbtn">Doctors Services</button>
  			<div class="dropdown-content">
    			<!--	<a href="<c:url value='/ManuhHospital/AddDoctorData'/>">Add New Doctor Data</a>-->
    				<a href="<c:url value='/ManuhHospital/GetDoctorRecords'/>">Get All Doctors Records</a>
    			<!--	<a href="#">Get Doctors Data By DID</a>-->
  			</div>
  		
			</div>
 		</div>
 </div>
</body>
</html>