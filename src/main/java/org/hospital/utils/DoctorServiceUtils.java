package org.hospital.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hospital.doctors.services.DoctorServices;
import org.hospital.domain.DoctorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DoctorServiceUtils implements DoctorServices {

	Logger logger = Logger.getLogger(DoctorServiceUtils.class.getName());

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public boolean addDoctorRecord(DoctorData doctorRecord) {

		String qury = "insert into doctor  ( DName, DGender, DAge, Daddress, Designation, Dphn, pid) values(?,?,?,?,?,?,?)";
		jdbc.update(qury, doctorRecord.getDName(), doctorRecord.getDGender(), doctorRecord.getDAge(),
				doctorRecord.getDAddress(), doctorRecord.getDesignation(), (doctorRecord.getDPhn()),
				doctorRecord.getPid());
		logger.info("From database " + doctorRecord.getDName() + "is inserted into the patient");
		return true;
	}

	@Override
	public List<DoctorData> getAllDoctorRecords() {
		List<DoctorData> doctorsRecordList = new ArrayList<DoctorData>();

		String query = "select * from doctor";
		doctorsRecordList = jdbc.query(query,
				(rs, rowNum) -> new DoctorData(rs.getInt("DID"), rs.getString("DName"), rs.getString("Dgender"),
						rs.getByte("Dage"), rs.getString("DAddress"), rs.getString("Designation"), rs.getLong("Dphn"),
						rs.getInt("pid")));
		logger.info("list" + doctorsRecordList);
		logger.info("From jdbc get all record is executed successfully");
		return doctorsRecordList;
	}

	@Override
	public DoctorData getDoctorByID(int DID) {
		String sqlQuery = "select * from doctor where DID = ?";
		Object[] args = { DID };

		DoctorData patient = jdbc.queryForObject(sqlQuery, BeanPropertyRowMapper.newInstance(DoctorData.class), args);
		return patient;

	}

	@Override
	public List<DoctorData> getDoctorsByPID(int pid) {

		List<DoctorData> doctorsRecordList = new ArrayList<DoctorData>();
		String query = "select * from doctor where pid = ?";
		Object[] args = { pid };
		doctorsRecordList = jdbc.query(query,
				(rs, rowNum) -> new DoctorData(rs.getInt("DID"), rs.getString("DName"), rs.getString("Dgender"),
						rs.getByte("Dage"), rs.getString("DAddress"), rs.getString("Designation"), rs.getLong("Dphn"),
						rs.getInt("pid")),
				args);
		logger.info("list" + doctorsRecordList);
		logger.info("From jdbc get all record is executed successfully");
		return doctorsRecordList;

	}

	@Override
	public DoctorData updateDoctorData(DoctorData doctorRecord) {
		// TODO Auto-generated method stub
		String qury = " update doctor set DName=?,DGender=?,DAge=?,DAddress=?,Designation=?,Dphn=?,pid=? where DID=?";
		jdbc.update(qury, doctorRecord.getDName(), doctorRecord.getDGender(), doctorRecord.getDAge(),
				doctorRecord.getDAddress(), doctorRecord.getDesignation(), (doctorRecord.getDPhn()),
				doctorRecord.getPid(), doctorRecord.getDid());
		logger.info("From database " + doctorRecord.getDName() + "is updated into the patient");
		// System.out.println("From database " + patient.getpid() + "is inserted into
		// the patien
		return doctorRecord;
	}

	@Override
	public boolean deleteDoctorRecord(int DID) {
		// TODO Auto-generated method stub
		String query = "delete from doctor where DID = ?";
		jdbc.update(query, DID);
		logger.info("From database deleted Patient record with" + " " + DID + " " + "patient ID");
		// System.out.println("From database deleted Patient record with" + " " + pid +
		// " " + "patient ID");
		return true;
	}

}
