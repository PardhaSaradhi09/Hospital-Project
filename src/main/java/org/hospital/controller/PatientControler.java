package org.hospital.controller;

import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.hospital.doctors.services.DoctorServices;
import org.hospital.domain.DoctorData;
import org.hospital.domain.PatientData;
import org.hospital.service.PatientService;
import org.hospital.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RestController
@RequestMapping("/ManuhHospital/")
public class PatientControler {

	@Autowired
	PatientService service;
	@Autowired
	DoctorServices docService;

	Logger logger = Logger.getLogger(PatientControler.class.getName());

	@GetMapping("AddPatientDataPage")
	public String addPatientFrom(Model uiModel, HttpSession session) {
		String x = ValidationUtil.logInValidation(session, uiModel);
		if (x != null) {
			return x;
		}
		return "AddPatientData";
	}

	@PostMapping("SubmittingPatientRecord")
	public String addPatient(@ModelAttribute PatientData patient, Model uiModel, HttpSession session) {
		String username = (String) session.getAttribute("username");

		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";
		}
		/* To validate the add data form */
		String error = ValidationUtil.validate(patient);
		if (error != null && error.trim().length() > 0) {
			uiModel.addAttribute("patient", patient);
			uiModel.addAttribute("emptyFieldError", error);
			return "AddPatientData";
		}
		/* After successful validation patient data will be added to the database */
		service.addPatient(patient);
		logger.info("Added Patient data ");
		List<PatientData> patientList = service.getAllPatients();
		uiModel.addAttribute("patientList", patientList);
		return "GetAllPatientss";
	}

	@GetMapping("EditPatientPage/{pid}")
	public String editPatient(@PathVariable String pid, Model uiModel, HttpSession session) {
		String username = (String) session.getAttribute("username");
		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";
		}
		PatientData patient;
		patient = service.getPatient(Integer.parseInt(pid));
		uiModel.addAttribute("patient", patient);
		return "EditPatientData";
	}

	@GetMapping("GetAllPatientRecordsPage")
	public ModelAndView getAllPatient(Model uiModel, HttpSession session, ModelAndView mv) {
		String username = (String) session.getAttribute("username");
		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			mv.setViewName("index");
			return mv;
		}
		List<PatientData> patientList = service.getAllPatients();
		uiModel.addAttribute("patientList", patientList);
		// return "GetAllPatientss";
		mv.setViewName("GetAllPatientss");
		return mv;
	}

	@PostMapping("UpdatingPatientRecord")
	public String updatePatientData(PatientData patient, Model uiModel, HttpSession session) {
		String username = (String) session.getAttribute("username");

		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";
		}
		/* To validate the edit patient data form */
		String error = ValidationUtil.validate(patient);
		if (error != null && error.trim().length() > 0) {
			uiModel.addAttribute("patient", patient);
			uiModel.addAttribute("emptyFieldError", error);
			return "EditPatientData";
		}
		/* After successful validation patient data will be update to the database */
		PatientData updatedPatient = service.updatePatientRecord(patient);
		logger.info("updated Patient record: " + updatedPatient);
		List<PatientData> patientList = service.getAllPatients();
		uiModel.addAttribute("patientList", patientList);
		return "GetAllPatientss";
	}

	@GetMapping("SearchPatient")
	public String searchPatientRecord(String pid, Model uiModel, HttpSession session) {
		String username = (String) session.getAttribute("username");
		PatientData patient = null;
		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";
		}
		if (pid.isEmpty()) {
			uiModel.addAttribute("inValidPid", "Please enter patient Id");
			List<PatientData> patientList = service.getAllPatients();
			uiModel.addAttribute("patientList", patientList);
			return "GetAllPatientss";
		}
		patient = service.getPatient(Integer.parseInt(pid));
		uiModel.addAttribute("searchPatient", patient);
		return "SearchPatientByPid";
	}

	@GetMapping("SortPatientRecordWithAge")
	public String sortByAge(Model uiModel, HttpSession session) {
		String username = (String) session.getAttribute("username");

		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";
		}
		List<PatientData> patientList = service.sortByAge();
		uiModel.addAttribute("patientList", patientList);
		return "GetAllPatientss";
	}

	@GetMapping("ViewDoctors/{pid}")
	public String viewPage(@PathVariable String pid, Model uiModel) {
		List<DoctorData> doctors = docService.getDoctorsByPID(Integer.parseInt(pid));
		logger.info("list size:" + doctors.size());
		uiModel.addAttribute("doctorList", doctors);
		return "GetAllDoctors";
	}

	// @RequestMapping(value="DeletePatientRecord/{pid}",
	// method=RequestMethod.DELETE)
	@GetMapping("DeletePatientRecord/{pid}")
	public ModelAndView deletePatientRecord(@PathVariable String pid, Model uiModel, HttpSession session,
			ModelAndView mv) {
		String username = (String) session.getAttribute("username");

		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			// return "index";
			mv.setViewName("index");
		}
		service.deletePatient(Integer.parseInt(pid));
		logger.info("From Servlet Deleted Patient record with " + pid + "patient ID");
		List<PatientData> patientList = service.getAllPatients();
		uiModel.addAttribute("patientList", patientList);
		// return "GetAllPatientss";
		mv.setViewName("GetAllPatientss");
		return mv;
	}

}
