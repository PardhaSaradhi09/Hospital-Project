package org.hospital.doctors.services;

import java.util.List;

import org.hospital.domain.DoctorData;


public interface DoctorServices {
	
	public boolean addDoctorRecord(DoctorData doctorRecord);
	
	public List<DoctorData> getAllDoctorRecords();
	
	public boolean deleteDoctorRecord(int DID);
	
	public DoctorData getDoctorByID(int DID);
	
	public List<DoctorData> getDoctorsByPID(int pid);
	
	public DoctorData updateDoctorData(DoctorData doctorRecord);

}
