package com.birlasoft.projectOne.DAO;

import java.util.List;

import com.birlasoft.projectOne.model.StudentVO;

public interface StudentDAO {
	public boolean addStudent(StudentVO student);
	public boolean deleteStudent(StudentVO student);
	public List<StudentVO> getstudentListById(int stuId);
}
