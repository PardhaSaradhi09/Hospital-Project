package org.hospital.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hospital.doctors.services.DoctorServices;
import org.hospital.domain.DoctorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ManuhHospital/")
public class DoctorController {

	@Autowired
	DoctorServices service;
	Logger logger = Logger.getLogger(DoctorController.class.getName());

	@GetMapping("AddDoctorData/{pid}")
	public String addDoctorForm(@PathVariable String pid, Model uiModel) {
		uiModel.addAttribute("pid", pid);
		uiModel.addAttribute("doctorRecord", new DoctorData());
		return "AddDoctor";
	}

	@PostMapping("AddDoctor")
	public String addDoctor(@Valid @ModelAttribute("doctorRecord") DoctorData doctorRecord, BindingResult error,
			Model uiModel) {
		if (error.hasErrors()) {
			// uiModel.addAttribute("doctorRecord", new DoctorData());
			logger.info("error" + error);
			uiModel.addAttribute("doctorRecord", doctorRecord);
			return "AddDoctor";
		}
		service.addDoctorRecord(doctorRecord);
		List<DoctorData> doctorList = service.getAllDoctorRecords();
		uiModel.addAttribute("doctorList", doctorList);
		return "GetAllDoctors";
	}

	@GetMapping("GetDoctorRecords")
	public ModelAndView getAllDoctors(ModelAndView mv) {
		List<DoctorData> doctorList = service.getAllDoctorRecords();
		mv.addObject("doctorList", doctorList);
		mv.setViewName("GetAllDoctors");
		return mv;
	}

	@DeleteMapping("DeleteDoctorData")
	public ModelAndView deleteDoctorRecord(String did, ModelAndView mv) {
		service.deleteDoctorRecord(Integer.parseInt(did));
		List<DoctorData> doctorList = service.getAllDoctorRecords();
		mv.addObject("doctorList", doctorList);
		mv.setViewName("GetAllDoctors");
		return mv;
	}

	@GetMapping("EditDoctor/{did}")
	public ModelAndView editDoctorRecord(@PathVariable Integer did, ModelAndView mv) {

		DoctorData doctor = service.getDoctorByID(did);
		mv.addObject("doctorRecord", doctor);
		mv.setViewName("EditDoctor");
		return mv;
	}

	@PostMapping("EditDoctor")
	public ModelAndView updateDoctorRecord(@Valid @ModelAttribute("doctorRecord") DoctorData doctorRecord,
			BindingResult error, ModelAndView mv) {
		if (error.hasErrors()) {
			// uiModel.addAttribute("doctorRecord", new DoctorData());
			logger.info("error" + error);
			mv.addObject("doctorRecord", doctorRecord);
			mv.setViewName("EditDoctor");
			return mv;
		}
		service.updateDoctorData(doctorRecord);
		List<DoctorData> doctorList = service.getAllDoctorRecords();
		mv.addObject("doctorList", doctorList);
		mv.setViewName("GetAllDoctors");
		return mv;
	}

	@GetMapping("SearchDoctor")
	public String searchDotorRecord(Integer did, Model uiModel, HttpSession session) {
		String username = (String) session.getAttribute("username");
		DoctorData doctor = null;
		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";
		}
		if (did == null) {
			uiModel.addAttribute("inValidDid", "Please enter doctor Id");
			List<DoctorData> doctorList = service.getAllDoctorRecords();
			uiModel.addAttribute("doctorList", doctorList);
			return "GetAllDoctors";
		}
		doctor = service.getDoctorByID(did);
		uiModel.addAttribute("searchDoctor", doctor);
		return "SearchDoctorByDid";
	}

	@GetMapping("/SortDoctorList")
	public ModelAndView sortDoctorList(ModelAndView mv) {
		return mv;
	}

}
