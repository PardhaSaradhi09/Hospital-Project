package org.hospital.service;

import java.util.List;

import org.hospital.domain.PatientData;

public interface PatientService {
	// This method will retrieve the patient record by patient id(pid).
	public PatientData getPatient(int pid) ;

	// Use this method to add Patient record into the hospital database.
	public Boolean addPatient(PatientData Patient);

	// This method will retrieve all patients records from hospital database.
	public List<PatientData> getAllPatients();

	// Use this method to delete Patient record from hospital database.
	public Boolean deletePatient(int pid) ;

	// Use this method to retrieve n patient records from database.
	public List<PatientData> topNPatients(int n);

	// This method will retrieve the all patient record by patient year of
	// join(year).
	public List<PatientData> getAllPatientsByYear(int year);

	// Use this method to update patient discharge date by patient id.
	public PatientData updatePatientRecord(PatientData patient);

	// This method will sort the patient records table by the patient age.
	public List<PatientData> sortByAge();
	

}
