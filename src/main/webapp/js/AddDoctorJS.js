//$(document).ready(function(){
//	 $("p").hide();
//	 
//	 /*$("#DoctorId").keyup(function(){
//		 var doctorId = $("#DoctorId").val();
//		 if(doctorId==""){
//			 $("p").show();
//			 alert("DoctorId must be required");
//			 return false;
//		}
//	 });*/
//	 
//
//});
$(document).ready(function(){
	//$("p").hide();
	$("#form").validate ({
		rules:{
			doctorId:"required",
			fname:"required",
			age:"required",
			gender:"required",
			DOj:"required",
		},
		messages:{
			doctorId:"Please enter Doctor Id",
			fname:"Please enter first name",
			age:"Please enter age",
			gender:"Please select gender",
			DOj:"Please enter date of join",
			
		},
	});
	$("#test").innerHTML=localStorage.getItem("ID");
});