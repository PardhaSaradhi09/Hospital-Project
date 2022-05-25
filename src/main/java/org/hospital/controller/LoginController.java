package org.hospital.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ManuhHospital/")
public class LoginController {
	@GetMapping("/")
	// @RequestMapping("/")
	private String index() {
		return "index";
	}

	@PostMapping("LogInServlet")
	private String menu(Model uiModel, @RequestParam String username, @RequestParam String password,
			HttpSession session) {
		if (username.equals("p.saragadam@manuhindia.com") && password.equals("password")) {
			session.setAttribute("username", username);
			uiModel.addAttribute("username", username);
			return "menu";
		} else {
			uiModel.addAttribute("error", "Invalid username and password");
			return "index";
		}

	}

}
