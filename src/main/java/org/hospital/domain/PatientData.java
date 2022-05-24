package org.hospital.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


public class PatientData {

	private Integer  pid;
	private String firstName;
	private String lastName;
	private String gender;
	private Integer age;
	private Long phn;
	private String address;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfJoin;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfDischarge;

	public PatientData(Integer pid, String firstName, String lastName, String gender, Integer age, Long phn, String address,
			LocalDate dateOfJoin, LocalDate dateOfDischarge) {
		super();
		this.pid = pid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.phn = phn;
		this.address = address;
		this.dateOfJoin = dateOfJoin;
		this.dateOfDischarge = dateOfDischarge;

	}

	public PatientData() {

	}

	public PatientData(String firstName, String lastName, String gender, int age, Long phn, String address,
			LocalDate dateOfJoin, LocalDate dateOfDischarge) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.phn = phn;
		this.address = address;
		this.dateOfJoin = dateOfJoin;
		this.dateOfDischarge = dateOfDischarge;
	}

	public Integer getpid() {
		return pid;
	}

	public void setpid(Integer pid) {
		this.pid = pid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String string) {
		this.gender = string;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getPhn() {
		return phn;
	}

	public void setPhn(Long phn) {
		this.phn = phn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public LocalDate getDateOfDischarge() {
		return dateOfDischarge;
	}

	public void setDateOfDischarge(LocalDate dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}

	@Override
	public String toString() {
		return "PatientData [pid=" + pid + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", age=" + age + ", phn=" + phn + ", address=" + address + ", dateOfJoin=" + dateOfJoin
				+ ", dateOfDischarge=" + dateOfDischarge + "]";
	}

	

}
