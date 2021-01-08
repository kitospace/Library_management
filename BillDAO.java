package com.birlasoft.projectOne.DAO;

import com.birlasoft.projectOne.model.BillVO;
import com.birlasoft.projectOne.model.BookVO;
import com.birlasoft.projectOne.model.StaffVO;
import com.birlasoft.projectOne.model.StudentVO;

public interface BillDAO {
	public boolean addbill(BillVO bill, BookVO book, StaffVO staff, StudentVO stud);
}
