package org.hospital.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class DoctorData {

	private Integer did;
	@NotEmpty(message = "name should not be empty")
	@Size(min = 5, max = 20, message = " name should be between 5 - 20 characters.")
	private String DName;
	@NotEmpty(message = "Please select a Gender")
	private String DGender;
	@NotNull(message = "age should not be empty")
	@Range(min = 18, message = "You cannot subscribe if you are under 18 years old.")
	private int DAge;
	private String DAddress;
	@NotEmpty(message = "Designation should not be empty")
	private String Designation;
	// @Pattern(regexp="(^$|[0-9]{10})", message = "Phone number should not be
	// empty")
	// @Size(min=10,max=10,message = "phone_no should be exact 10 characters.")
	private long DPhn;
	private Integer pid;

	public DoctorData(Integer did, String dName, String dGender, int dAge, String dAddress, String designation,
			long dPhn, Integer pid) {
		super();
		this.did = did;
		this.DName = dName;
		this.DGender = dGender;
		this.DAge = dAge;
		this.DAddress = dAddress;
		this.Designation = designation;
		this.DPhn = dPhn;
		this.pid = pid;
	}

	public DoctorData() {
		// TODO Auto-generated constructor stub
	}

	public DoctorData(String dName, String dGender, int dAge, String dAddress, String designation, long dPhn,
			Integer pid) {
		// TODO Auto-generated constructor stub
		this.DName = dName;
		this.DGender = dGender;
		this.DAge = dAge;
		this.DAddress = dAddress;
		this.Designation = designation;
		this.DPhn = dPhn;
		this.pid = pid;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDName() {
		return DName;
	}

	public void setDName(String dName) {
		DName = dName;
	}

	public String getDGender() {
		return DGender;
	}

	public void setDGender(String dGender) {
		DGender = dGender;
	}

	public int getDAge() {
		return DAge;
	}

	public void setDAge(int dAge) {
		DAge = dAge;
	}

	public String getDAddress() {
		return DAddress;
	}

	public void setDAddress(String dAddress) {
		DAddress = dAddress;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public long getDPhn() {
		return DPhn;
	}

	public void setDPhn(long dPhn) {
		DPhn = dPhn;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "DoctorData [did=" + did + ", DName=" + DName + ", DGender=" + DGender + ", DAge=" + DAge + ", DAddress="
				+ DAddress + ", Designation=" + Designation + ", DPhn=" + DPhn + ", pid=" + pid + "]";
	}

}
