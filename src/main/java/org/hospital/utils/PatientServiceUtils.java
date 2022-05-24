package org.hospital.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hospital.domain.PatientData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PatientServiceUtils {

	Logger logger = Logger.getLogger(PatientServiceUtils.class.getName());
	@Autowired
	JdbcTemplate jdbc;
	
	
	public Boolean insertRecord(PatientData patient)  {
	//try {
			
			String qury = " insert into patient ( firstName, lastName, gender, age, phn, address, dateOfJoin, dateOfdischarge) values(?,?,?,?,?,?,?,?);";
			jdbc.update(qury, patient.getFirstName(), patient.getLastName(), patient.getGender(), patient.getAge(),
					patient.getPhn(), (patient.getAddress()), (patient.getDateOfJoin()),
					(patient.getDateOfDischarge()));

			logger.info("From database " + patient.getFirstName() + "is inserted into the patient");
			// System.out.println("From database " + patient.getpid() + "is inserted into
			// the patien
			return true;
//		} catch (Exception e) {
//			return false;
//		}

	}

	public List<PatientData> getAllRecords() {

		List<PatientData> patientList = new ArrayList<PatientData>();
		String query = "select * from patient";
		patientList = jdbc.query(query,
				(rs, rowNum) -> new PatientData(rs.getInt("pid"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("gender"), rs.getInt("age"), rs.getLong("phn"), rs.getString("address"),
						rs.getDate("dateOfJoin").toLocalDate(), rs.getDate("dateOfDischarge").toLocalDate()));
		logger.info("list" + patientList);
		logger.info("From jdbc get all record is executed successfully");

		return patientList;

	}

	public Boolean deleteRecord(int pid)  {
		//try {
		String query = "delete from patient where pid = ?";
		jdbc.update(query, pid);
		logger.info("From database deleted Patient record with" + " " + pid + " " + "patient ID");
		// System.out.println("From database deleted Patient record with" + " " + pid +
		// " " + "patient ID");
		return true;
//		}catch (Exception e) {
//			logger.info(e.getMessage());
//			return false;
//		}
	}

	public PatientData getRecordFromTable(int pid)  {
		String sqlQuery = "select * from patient where pid = ?";
		Object[] args = { pid };
		PatientData patient = jdbc.queryForObject(sqlQuery,  BeanPropertyRowMapper.newInstance(PatientData.class), args);
		return patient;

	}

	public List<PatientData> topNRecords(int n) {
		
		List<PatientData> topTatientList = new ArrayList<PatientData>();
		//String query = "select * from patient limit ?";
//		topTatientList.add((PatientData) jdbc.query(query,
//				(rs, rowNum) -> new PatientData(rs.getInt("pid"), rs.getString("firstName"), rs.getString("lastName"),
//						rs.getString("gender"), rs.getByte("age"), rs.getLong("phn"), rs.getString("address"),
//						rs.getDate("dateOfJoin").toLocalDate(), rs.getDate("dateOfDischarge").toLocalDate())));

		return topTatientList;
	}

	public List<PatientData> getAllRecordsByYear(int year) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PatientData> sortByAge() {
		List<PatientData> patientList = new ArrayList<PatientData>();

		String query = "SELECT * FROM patient ORDER BY age Desc";
		patientList = jdbc.query(query,
				(rs, rowNum) -> new PatientData(rs.getInt("pid"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("gender"), rs.getInt("age"), rs.getLong("phn"), rs.getString("address"),
						rs.getDate("dateOfJoin").toLocalDate(), rs.getDate("dateOfDischarge").toLocalDate()));
		logger.info("list" + patientList);
		logger.info("From jdbc get all record is executed successfully");
		return patientList;
	}

	public PatientData updatePatientRecord(PatientData patient) {
		// TODO Auto-generated method stub
		String qury = "update patient set firstName=?,lastName=?,gender=?,age=?,phn=?,address=?,dateOfJoin=?,dateOfDischarge=? where pid=?;";
		jdbc.update(qury, patient.getFirstName(), patient.getLastName(), patient.getGender(), patient.getAge(),
				patient.getPhn(), (patient.getAddress()), (patient.getDateOfJoin()), (patient.getDateOfDischarge()),
				patient.getpid());
		logger.info("From database " + patient.getFirstName() + "is updated into the patient");
		return patient;
	}

}
