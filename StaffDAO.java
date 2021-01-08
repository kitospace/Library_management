package com.birlasoft.projectOne.DAO;

import java.util.List;

import com.birlasoft.projectOne.model.StaffVO;

public interface StaffDAO {
	public boolean addStaff(StaffVO staff);
	public boolean deleteStaff(StaffVO staff);
	public List<StaffVO> getstaffListBystaffId(String staffId);
}
