package org.hospital.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ManuhHospital")
public class NavigtionController {
	
	@GetMapping("/LogOutServlet")
	private String logOut(ModelMap model, HttpSession session) {
		session.invalidate();
		model.put("logOutError", "Successfully loggedout");
		return "index";

	}
	
	@GetMapping("/menu")
	public String backToMenu() {
		return "menu";

	}
	
//	@GetMapping("/AddPatientData")
//	public String addPatientForm() {
//		return "AddPatientData";
//	}
	

}
