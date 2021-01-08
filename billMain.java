package com.birlasoft.projectOne.main;


import java.util.Scanner;

import com.birlasoft.projectOne.DAO.BillDAO;
import com.birlasoft.projectOne.DAO.BillDAOImpl;
import com.birlasoft.projectOne.model.BillVO;
import com.birlasoft.projectOne.model.BookVO;
import com.birlasoft.projectOne.model.StaffVO;
import com.birlasoft.projectOne.model.StudentVO;

public class billMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BillDAO billDao = new BillDAOImpl();
		while(true){
		System.out.println("This is Billing Place");
		System.out.println("Enter Staff-Id: ");
		String staffId = sc.next();
		System.out.println("Enter Bill-id: ");
		int billId = sc.nextInt();
		System.out.println("Enter Bill Date: ");
		String billDate = sc.next();
		System.out.println("Enter Book Id: ");
		String bookId = sc.next();
		System.out.println("Enter Student Id : ");
		int stuId = sc.nextInt();
		System.out.println("Enter Value : ");
		int billval = sc.nextInt();
		
		BillVO bill = new BillVO();
		bill.setBILLID(billId);
		bill.setBILLDATE(billDate);
		bill.setBILLVALUE(billval);
		StaffVO staff = new StaffVO();
		staff.setStaffId(staffId);
		StudentVO stu = new StudentVO();
		stu.setStuId(stuId);
		BookVO book = new BookVO();
		book.setBookId(bookId);
		
		boolean result = billDao.addbill(bill, book, staff, stu);
		if(result){
			System.out.println("Bill is feeded");
			
		}
		else{
			System.out.println("Some Error in the system......");
		}
		
	}
}
}