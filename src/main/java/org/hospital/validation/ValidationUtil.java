package org.hospital.validation;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hospital.domain.PatientData;
import org.springframework.ui.Model;

public class ValidationUtil {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static  String validate(PatientData patient) {
		//Map<String, String> errorMessages = new HashMap<>();
		String fname = patient.getFirstName();
		String lname = patient.getLastName();
		String gender = patient.getGender();
		Integer age = patient.getAge();
		Long phoneNumber = patient.getPhn();
		String city = patient.getAddress();
		LocalDate doj = patient.getDateOfJoin();
		LocalDate dod =patient.getDateOfDischarge();
		String error = "";
		if (fname == null || fname.trim().length() == 0) {
			error = "First name should not be empty";
			//errorMessages.put("fnameError", error);
		} else if (lname == null || lname.trim().length() == 0) {
			error = "Last name should not be empty";
			//errorMessages.put("lnameError", error);
		} else if (gender == null || gender.trim().length() == 0) {
			error = "gender should not be empty";
			//errorMessages.put("genderError", error);
		} else if (age == null || String.valueOf(age).trim().length()==0 ) {
			error = "age should not be empty";
			//errorMessages.put("ageError", error);
		} else if (phoneNumber == null || String.valueOf(phoneNumber).trim().length()==0 ) {
			error = "phoneNumber should not be empty";
			//errorMessages.put("phoneNumberError", error);
		} else if (city == null || city.trim().length() == 0) {
			error = "city should not be empty";
			//errorMessages.put("cityError", error);
		} 
		else if (doj == null || doj.toString().trim().length()==0 ) {

			error = "doj should not be empty";
			//errorMessages.put("dojError", error);
		} else if (dod == null || dod.toString().trim().length()==0 ) {
			error = "dod should not be empty";
			//errorMessages.put("dodError", error);
		}
		if (doj != null && doj.toString().trim().length() > 0) {
			try {
				LocalDate.parse(dod.toString(), dtf);
			} catch (Exception e) {
				error = String.format("invalid doj.error:%s", e.getMessage())+"\n Date of join should in \"yyyy-MM-dd\" format";
			}
		}
		if (dod != null && dod.toString().trim().length()> 0) {
			try {
				LocalDate.parse(dod.toString(), dtf);
			} catch (Exception e) {
				error = String.format("invalid dod.error:%s", e.getMessage())+"\n Date of discharge should in \"yyyy-MM-dd\" format";
			}

		}

		return error;
	}
	
	public static String doctorFormValidate(HttpServletRequest request) {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("address");
		String designation = request.getParameter("designation");
		String phoneNumber=request.getParameter("phn");
		//String pid = request.getParameter("pid");
		String error="";
		
		if(name==null || name.trim().length()==0) {
			error="Doctor name should not be empty";
		}else if(gender==null || gender.trim().length()==0) {
			error="Gender should be empty";
		}else if (age == null || age.trim().length() == 0) {
			error = "age should not be empty";
		} else if (city == null || city.trim().length() == 0) {
			error = "city should not be empty";
		}else if (designation == null || designation.trim().length() == 0) {
			error = "designation should not be empty";
		}  else if (phoneNumber == null || phoneNumber.trim().length() == 0) {
			error = "phoneNumber should not be empty";
		}
//		else if(pid == null || pid.trim().length()==0) {
//			error = "Patient Id should not be empty";
//		}
		
		return error;
		
	}
	
	public static String logInValidation(HttpSession session, Model uiModel) {
		String username = (String) session.getAttribute("username");
		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";
		}
		return null;
	}

}
