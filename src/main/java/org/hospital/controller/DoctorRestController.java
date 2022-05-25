package org.hospital.controller;

import java.util.List;
import java.util.logging.Logger;

import org.hospital.doctors.services.DoctorServices;
import org.hospital.domain.DoctorData;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DoctorRestController {

	@Autowired
	DoctorServices service;
	Logger logger = Logger.getLogger(DoctorRestController.class.getName());

	@GetMapping("GetAllDoctor")
	public List<DoctorData> getAllDoctors() {

		return service.getAllDoctorRecords();
	}
	
	@PostMapping("addDoctor")
	public List<DoctorData> addDoctor( @RequestBody DoctorData doctorRecord) {
		
		service.addDoctorRecord(doctorRecord);
		
		return service.getAllDoctorRecords();
	}
	
	@PutMapping("editDoctor")
	public List<DoctorData> updateDoctor( @RequestBody DoctorData doctorRecord) {
		
		service.updateDoctorData(doctorRecord);
		
		return service.getAllDoctorRecords();
	}
	
	@DeleteMapping("deleteDoctor/{did}")
	public List<DoctorData> deleteDoctor(@PathVariable int did) {
		
		service.deleteDoctorRecord(did);
		return service.getAllDoctorRecords();
	}
	
	@GetMapping("getDoctorBydid/{did}")
	public DoctorData getDoctorBydid(@PathVariable int did) {

		return service.getDoctorByID(did);
	}
}
