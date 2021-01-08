package com.birlasoft.projectOne.service;

import com.birlasoft.projectOne.model.StaffVO;

public interface StaffService {
	public boolean ValidationStaffId(StaffVO staff);
	public boolean ValidationStaffPNo(StaffVO staff);
	public boolean ValidationStaffDOB(StaffVO staff);
}
