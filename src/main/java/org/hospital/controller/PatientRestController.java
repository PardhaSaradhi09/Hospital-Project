package org.hospital.controller;

import java.util.List;
import java.util.logging.Logger;

import org.hospital.custom.exceptions.PatientIdNotFoundException;
import org.hospital.doctors.services.DoctorServices;
import org.hospital.domain.DoctorData;
import org.hospital.domain.PatientData;
import org.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restAPI/")
public class PatientRestController {

	@Autowired
	PatientService service;
	@Autowired
	DoctorServices docService;

	Logger logger = Logger.getLogger(PatientRestController.class.getName());

	@GetMapping(value = "getAllPatients", produces = "application/json")
	public List<PatientData> getAllPatient() {

		return service.getAllPatients();
		
	}

	@GetMapping("getPatientById/{pid}")
	public PatientData getPatientById(@PathVariable int pid) {
			return service.getPatient(pid);
			
	}

	@PostMapping(value="addPatient")
	public List<PatientData> addPatient(@RequestBody PatientData patient) {

		service.addPatient(patient);
		return service.getAllPatients();
	}
	
	@PutMapping("editPatient")
	public PatientData updatePatientData(@RequestBody PatientData patient ) {

		return service.updatePatientRecord(patient);
	}
	
	@DeleteMapping("deletePatient/{pid}")
	public Boolean deletePatientData( @PathVariable int pid ) {

		return service.deletePatient(pid);
	}
	
	@GetMapping("getDoctorsWithPatientId/{pid}")
	public List<DoctorData> getDoctorsWithPatientId( @PathVariable int pid ) {

		return docService.getDoctorsByPID(pid);
	}
	
	@GetMapping("sortPatientListByAge" )
	public List<PatientData> sortPatientListByAge() {

		return service.sortByAge();
	}

}
