package com.birlasoft.projectOne.model;

public class StaffVO {
	private String staffId;
	private String staffName;
	private String staffAge;
	private String staffDpet;
	private String staffPNo;
	private String staffDOB;
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffAge() {
		return staffAge;
	}
	public void setStaffAge(String staffAge) {
		this.staffAge = staffAge;
	}
	public String getStaffDpet() {
		return staffDpet;
	}
	public void setStaffDpet(String staffDpet) {
		this.staffDpet = staffDpet;
	}
	public String getStaffPNo() {
		return staffPNo;
	}
	public void setStaffPNo(String staffPNo) {
		this.staffPNo = staffPNo;
	}
	public String getStaffDOB() {
		return staffDOB;
	}
	public void setStaffDOB(String staffDOB) {
		this.staffDOB = staffDOB;
	}
	@Override
	public String toString() {
		return "StaffVO [staffId=" + staffId + ", staffName=" + staffName
				+ ", staffAge=" + staffAge + ", staffDpet=" + staffDpet
				+ ", staffPNo=" + staffPNo + ", staffDOB=" + staffDOB + "]";
	}
	public StaffVO(String staffId, String staffName, String staffAge,
			String staffDpet, String staffPNo, String staffDOB) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffAge = staffAge;
		this.staffDpet = staffDpet;
		this.staffPNo = staffPNo;
		this.staffDOB = staffDOB;
	}
	public StaffVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
