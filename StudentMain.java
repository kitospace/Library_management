package com.birlasoft.projectOne.main;

import java.util.Scanner;

import com.birlasoft.projectOne.DAO.StudentDAOImpl;
import com.birlasoft.projectOne.DAO.StudentDAO;
import com.birlasoft.projectOne.util.DBOracleConnection;
import com.birlasoft.projectOne.model.StudentVO;
import com.birlasoft.projectOne.service.StudentServiceImpl;
import com.birlasoft.projectOne.service.StudentService;

public class StudentMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StudentService stuservice = new StudentServiceImpl();
		StudentDAO stuDAO= new StudentDAOImpl();
		
		System.out.println("Student Information Appliaction");
		while (true) {
			System.out.println("This is Signing up application for the new Student in the library,\nkindly provide your genuine Information");
			System.out.println("Enter Student Information");
			System.out.println("Enter your Roll no. : ");
			int id = sc.nextInt();
			System.out.println("Enter your name : ");
			String name = sc.next();
			System.out.println("Enter your Age : ");
			String age = sc.next();
			System.out.println("Enter your Phone Number : ");
			String PNo = sc.next();
			System.out.println("Enter yout Date of Birth:");
			String DOB = sc.next();
			
			StudentVO student = new StudentVO(id, name, age, PNo, DOB);
				
			boolean result = stuservice.validationphoneNo(student);
			if(result){
				System.out.println("Data is Validated");
				
				result = stuDAO.addStudent(student);
				
				if(result){
					System.out.println("Student Added Successfully");
				}else{
					System.out.println("Not Added");
				}
			}else{
				System.out.println("Format of phone number is not correct");
			}					
		}
	}
}
