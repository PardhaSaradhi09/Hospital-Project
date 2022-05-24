package org.hospital.domain;

import java.time.LocalDate;

public class FinanceData {

	private int pid, billID;
	private String firstName;
	private String lastName;
	private char gender;
	private byte age;
	private int doctorID;
	private double billAmount;
	private String paymentType;
	private double billDue;
	private LocalDate billDate;

	public FinanceData(int pid, int billID, String firstName, String lastName, char gender, byte age, int doctorID,
			double billAmount, String paymentType, double billDue, LocalDate billDate) {
		super();
		this.pid = pid;
		this.billID = billID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.doctorID = doctorID;
		this.billAmount = billAmount;
		this.paymentType = paymentType;
		this.billDue = billDue;
		this.billDate = billDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public FinanceData() {

	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getbillID() {
		return billID;
	}

	public void setbillID(int billID) {
		this.billID = billID;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public double getBillDue() {
		return billDue;
	}

	public void setBillDue(double billDue) {
		this.billDue = billDue;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	@Override
	public String toString() {
		return "PatientBillDetails [pid=" + pid + ", billID=" + billID + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", age=" + age + ", doctorID=" + doctorID + ", billAmount="
				+ billAmount + ", paymentType=" + paymentType + ", billDue=" + billDue + ", billDate=" + billDate + "]";
	}

}
