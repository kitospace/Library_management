package com.birlasoft.projectOne.model;

public class BillVO {
	private int BILLID;
	private String BILLDATE;
	private int BILLVALUE;
	
	public int getBILLID() {
		return BILLID;
	}
	public void setBILLID(int bILLID) {
		BILLID = bILLID;
	}
	public String getBILLDATE() {
		return BILLDATE;
	}
	public void setBILLDATE(String bILLDATE) {
		BILLDATE = bILLDATE;
	}
	public int getBILLVALUE() {
		return BILLVALUE;
	}
	@Override
	public String toString() {
		return "BillVO [BILLID=" + BILLID + ", BILLDATE=" + BILLDATE
				+ ", BILLVALUE=" + BILLVALUE + "]";
	}
	public void setBILLVALUE(int bILLVALUE) {
		BILLVALUE = bILLVALUE;
	}
	public BillVO(int bILLID, String bILLDATE, int bILLVALUE) {
		super();
		BILLID = bILLID;
		BILLDATE = bILLDATE;
		BILLVALUE = bILLVALUE;
	}
	public BillVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
