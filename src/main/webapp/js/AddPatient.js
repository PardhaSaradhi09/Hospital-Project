function validateForm(){
	 let patientId = document.forms["form"]["patientId"].value;
	 let fname = document.forms["form"]["fname"].value;
	 let age = document.forms["form"]["age"].value;
	
	 if( patientId==""){
		 alert("patientId must be required");
		 return false;
		 
	 }
	 else if(fname==""){
		 alert("First name must be required");
		 return false;
	 }
	 else if(age==""){
		 alert("age must be required");
		 return false;
	 }
}

//$(document).ready(function(){
//	var patientId = $("patientId").val();
//	localStorage.setItem("ID", patientId );
//	window.location.href="NewDoctorData.html";
//	return false;
//	
//}