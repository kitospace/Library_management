package com.birlasoft.projectOne.service;

import com.birlasoft.projectOne.model.StudentVO;

public class StudentServiceImpl implements StudentService{
	
	
	public boolean validationphoneNo(StudentVO student){
		boolean result = false;
		String PNo = student.getStuNum();
		
		if(PNo.length()==10 && PNo!=null){
			result=true;
		}
		return result;
	}

}
