package org.hospital.service;

import java.util.List;

import org.hospital.domain.PatientData;
import org.hospital.utils.PatientServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientJdbcServiceImpl implements PatientService {

	@Autowired
	PatientServiceUtils util;

	@Override
	/* To retrieve specific patient by pid we can use the getPatient(Pid) method */
	public PatientData getPatient(int pid) {

		return util.getRecordFromTable(pid);

	}

	@Override
	/* To add the record in the database we can use this method */

	public Boolean addPatient(PatientData patient) {

		return util.insertRecord(patient);
	}

	@Override
	public List<PatientData> getAllPatients() {

		return util.getAllRecords();
	}

	@Override
	public Boolean deletePatient(int pid) {

		return util.deleteRecord(pid);
	}

	@Override
	public List<PatientData> topNPatients(int n) {

		return util.topNRecords(n);
	}

	@Override
	public List<PatientData> getAllPatientsByYear(int year) {

		return util.getAllRecordsByYear(year);
	}

	@Override
	public List<PatientData> sortByAge() {

		return util.sortByAge();
	}

	@Override
	public PatientData updatePatientRecord(PatientData patient) {
		// TODO Auto-generated method stub
		return util.updatePatientRecord(patient);
	}

}
