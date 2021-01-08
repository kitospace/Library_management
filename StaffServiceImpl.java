package com.birlasoft.projectOne.service;

import com.birlasoft.projectOne.model.StaffVO;

public class StaffServiceImpl implements StaffService {
	public boolean ValidationStaffId(StaffVO staff){
		boolean result = false;
		String id = staff.getStaffId();
		if(id.length()==5&&id.isEmpty()!=true){
			result = true;
		}
		return result;
	}
	public boolean ValidationStaffPNo(StaffVO staff){
		boolean result = false;
		String PNo = staff.getStaffPNo();
		if(PNo.length()==10&&PNo.isEmpty()!=true){
			result = true;
		}
		return result;
	}
	public boolean ValidationStaffDOB(StaffVO staff){
		boolean result = false;
		String DOB = staff.getStaffDOB();
		if(DOB.isEmpty()!=true){
			result = true;
		}
		return result;
	}
}
