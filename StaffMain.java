package com.birlasoft.projectOne.main;

import java.util.List;
import java.util.Scanner;

import com.birlasoft.projectOne.DAO.BookDAO;
import com.birlasoft.projectOne.DAO.BookDAOImpl;
import com.birlasoft.projectOne.DAO.StaffDAO;
import com.birlasoft.projectOne.DAO.StaffDAOImpl;
import com.birlasoft.projectOne.DAO.StudentDAO;
import com.birlasoft.projectOne.DAO.StudentDAOImpl;
import com.birlasoft.projectOne.model.BookVO;
import com.birlasoft.projectOne.model.StaffVO;
import com.birlasoft.projectOne.model.StudentVO;
import com.birlasoft.projectOne.service.StaffService;
import com.birlasoft.projectOne.service.StaffServiceImpl;
import com.birlasoft.projectOne.service.StudentService;
import com.birlasoft.projectOne.service.StudentServiceImpl;

public class StaffMain{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BookDAO bookDAO = new BookDAOImpl();
		StudentDAO stuDao = new StudentDAOImpl();
		StudentService stuService = new StudentServiceImpl();
		StaffService staffServ = new StaffServiceImpl();
		StaffDAO staffDao = new StaffDAOImpl();
		
		while(true){
		System.out.println("This is Main Database System of Library.");
		System.out.println(" ");
		System.out.println("Enter 1 for Staff Database,\nEnter 2 for Student Database,\nEnter 3 for Library Database.");
		int input = sc.nextInt();
		if(input==1){
			System.out.println("Enter 1 to add Staff Information\nEnter 2 to Delete Staff Infomation,\nEnter 3 to View Detail of Staff.");
			int staffInput = sc.nextInt();
			if(staffInput==1){
				System.out.println("Please give the correct values below to add information.");
				System.out.println("Enter Staff-Id : ");
				String Sid = sc.next();
				System.out.println("Enter Staff Name : ");
				String Sname = sc.next();
				System.out.println("Enter Staff Age : ");
				String Sage = sc.next();
				System.out.println("Enter Staff Department : ");
				String Sdpt = sc.next();
				System.out.println("Enter Staff Phone No. : ");
				String SPNo = sc.next();
				System.out.println("Enter Staff DOB : ");
				String SDOB = sc.next();
				
				StaffVO staff = new StaffVO(Sid, Sname, Sage, Sdpt, SPNo, SDOB);
				
				boolean result = staffServ.ValidationStaffId(staff);
				if(result){
					result = staffServ.ValidationStaffPNo(staff);
					if(result){
						result = staffServ.ValidationStaffDOB(staff);
						if(result){
							result = staffDao.addStaff(staff);
							if(result){
								System.out.println("Staff Data Saved ;)");
							}else{
								System.out.println("Something is wrong, data not Saved :,(");
							}
						}else{
							System.out.println("DOB Missing!!, Data remain unsaved");
						}
					}else{
						System.out.println("Phone Number is missing or Phone Number length must be 10 number, Data remain unsaved");
					}
				}else{
					System.out.println("Id is Missing or the length of Id must be 5,\nData remain unsaved");
				}
			}
			else if(staffInput==2){
				System.out.println("Enter the Staff Id to delete Staff from Database.");
				String id = sc.next();
				
				StaffVO staff = new StaffVO();
				staff.setStaffId(id);
				
				boolean result = staffServ.ValidationStaffId(staff);
				if(result){
					result = staffDao.deleteStaff(staff);
					if(result){
						System.out.println("Data Deleted ;}");
					}else{
						System.out.println("Data Not Deleted :-(");
					}
				}else{
					System.out.println("Id is Missing or the length of Id must be 5");
				}
			}else if(staffInput==3){
				System.out.println("Enter Staff Id for Staff full detail..");
				String staffId = sc.next();
				
				List<StaffVO> staffList = staffDao.getstaffListBystaffId(staffId);
		
				for(StaffVO staff :staffList)
				{
					System.out.println(" ");
					System.out.println("Staff Id : "+staff.getStaffId());
					System.out.println("Staff Name : "+staff.getStaffName());
					System.out.println("Staff Age : "+staff.getStaffAge());
					System.out.println("Staff Department : "+staff.getStaffDpet());
					System.out.println("Staff Phone No. : "+staff.getStaffPNo());
					System.out.println("Staff DOB : "+staff.getStaffDOB());
					System.out.println(" ");
				}
			}else{
				System.out.println("Enter valid Input..!!!");
			}
		}else if(input==2){
			System.out.println("Enter 1 to add Student Information\nEnter 2 to Delete Student Infomation,\nEnter 3 to View Detail of Student.");
			int studentInp=sc.nextInt();
			if(studentInp==1){
				System.out.println("Please give the correct values below to add information.");
				System.out.println("Enter your Roll no. : ");
				int id = sc.nextInt();
				System.out.println("Enter your full name : ");
				String name = sc.next();
				System.out.println("Enter your Age : ");
				String age = sc.next();
				System.out.println("Enter your Phone Number : ");
				String PNo = sc.next();
				System.out.println("Enter yout Date of Birth:");
				String DOB = sc.next();
				
				StudentVO student = new StudentVO(id, name, age, PNo, DOB);
				boolean result = stuService.validationphoneNo(student);
				if(result){
					System.out.println("Data is Validated");
					
					result = stuDao.addStudent(student);
					
					if(result){
						System.out.println("Student Added Successfully");
					}else{
						System.out.println("Not Added");
					}
				}else{
					System.out.println("Format of phone number is not correct");
				}
				
			}else if(studentInp==2){
				System.out.println("Enter the Student Id to delete Student from Database.");
				int id = sc.nextInt();
				
				StudentVO student = new StudentVO();
				student.setStuId(id);
				
					boolean result = stuDao.deleteStudent(student);
					if(result){
						System.out.println("Data Deleted ;}");
					}else{
						System.out.println("Data Not Deleted :-(");
					}
				}else if(studentInp==3){
					System.out.println("Enter Student Id for Student full detail..");
					int stuId = sc.nextInt();
					
					List<StudentVO> stuList = stuDao.getstudentListById(stuId);
			
					for(StudentVO student :stuList)
					{
						System.out.println(" ");
						System.out.println("Student Id : "+student.getStuId());
						System.out.println("Student Name : "+student.getStuName());
						System.out.println("Student Age : "+student.getStuAge());
						System.out.println("Student Phone No. : "+student.getStuNum());
						System.out.println("Student DOB : "+student.getStuDOB());
						System.out.println(" ");
					}
					
				}
				
			}else if(input==3){

				System.out.println("Enter 1 to add Book Information\nEnter 2 to Delete Book Infomation,\nEnter 3 to View Detail of Book.");
				int bookInp=sc.nextInt();
				if(bookInp==1){
					System.out.println("Please give the correct values below to add information.");
					System.out.println("Enter Book Id : ");
					String bookid = sc.next();
					System.out.println("Enter Book name : ");
					String bookname = sc.next();
					System.out.println("Enter Book MRP : ");
					String bookMrp = sc.next();
					System.out.println("Enter Book Author : ");
					String bookAuth = sc.next();
					System.out.println("Enter Book Genre:");
					String bookGen = sc.next();
					System.out.println("Enter the Quantity of Book: ");
					String bookNum = sc.next();
					
					BookVO book = new BookVO(bookid, bookname, bookMrp, bookAuth, bookGen, bookNum);
					
					boolean	result = bookDAO.addBook(book);
						if(result){
							System.out.println("Book Added Successfully");
						}else{
							System.out.println("Book Not Added");
						}
						}	
				else if(bookInp==2){
					System.out.println("Enter the Book Id to delete Book from Database.");
					String id = sc.next();
					
					BookVO book = new BookVO();
					book.setBookId(id);
					
						boolean result = bookDAO.deleteBook(book);
						if(result){
							System.out.println("Data Deleted ;}");
						}else{
							System.out.println("Data Not Deleted :-(");
						}
					}else if(bookInp==3){
						System.out.println("Enter Book Name for Book full detail..");
						String bookname = sc.next();
						
						List<BookVO> bookList = bookDAO.getbookListByName(bookname);
				
						for(BookVO book :bookList)
						{
							System.out.println(" ");
							System.out.println("Book Id : "+book.getBookId());
							System.out.println("Book Name : "+book.getBookName());
							System.out.println("Book MRP : "+book.getBookMRP());
							System.out.println("Book Author : "+book.getBookAuth());
							System.out.println("Book Genre : "+book.getBookGenre());
							System.out.println("Number of Books in Lib : "+book.getBookNumber());
							System.out.println(" ");
						}
					}
				
			}
			else{
				System.out.println("Enter valid Input..!!!");
			}
			
			
		}
			
		}
		
	}

