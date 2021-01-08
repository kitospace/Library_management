Software Requirements Specification
For
LIBRARY MANAGEMENT SYSTEM
1. PROJECT OBJECTIVE:
	The main objective of this project is to having a working console based Library Management where the Staff Member can manage the data about books in the library, students, bills and staff member record. This management system mainly concentrates on books in the library, staff member’s record, bill records and the students in the library and their past record. The system focuses on providing the user the valid and genuine past and updated information about Library. The project looks forward to have an easy to control and understand the data management in Library.
The system also secretly provides for an admin user (let say staff member), who can add, delete or review the list as per the requirement and also know the information concerning the bills. This is also done dynamically and in real time.

 2. PROJECT SCOPE:
	This projects looks into giving the user as much option which can inhance the rate of working ethics in a Library. The scope of this project is to provide the user access to the database and login into the system or creates as many new logins as the user wishes. It considers the user relevant interest by adding, deleting, updating and maintaining all the data as much as they can. It also needs to keep the integrity together bounded to the user and the bill management.
Furthermore, the project also provides with an user(Staff Member) who will have the access to monitor the details in the database and will also have control over the details.

3. APPLICATION FUNCTIONALITY:
3.1 Adding New Student:  
The project enables any number of new students to be the part of irrespective of the data given. During the addition of a new student to the database, the user (student) is supposed to give relevant details and also follow the instructions given. 

3.2 Adding New Book: 
	The staff member can manage the record of the books present in the Library by adding all the genuine information to the system. The system will ask for the information about the new book which will be going to be added like Name of the Book, Number of Books in the Library, Genre of the Book, Cost of the book, and others. The user needs to follow the instructions.

3.3 Deletion of Information:
	This system provides an access to the user to delete the information with the help of Id which the user has to input in the system. It can delete the Student, Book and Staff information from database permanently. 
3.4 Viewing/Retrieving Data:
	This system gives the power to the user to retrieve the data from database. The system can gives the information about student, or books detail, or even staff member can know retrieve their personal given data so that in any case of mistake inputs during adding data, so they can update it in the database later as per the need and requirement.  

4. APPLICATION USER:
a) User: The user of this application can be Student or Staff Member of the library, but Student can add their data where the staff member can add student, staff member, book data, or can delete student, staff, book data, or can View any of the data from the database.
BACKEND: ORACLE DATABASE

5. ER DIAGRAM:
a) User
 

6. DATABASE DESIGN:
	
	The user as in staff member will only be able to acces details of the every table and also will have the access to delete or add data. The unnoticeable part, i.e., the billing of library books is linked with the student-Id and Staff-Id. Here the BILLOFLIB is master table. 
There are 4 tables in my database:
a)	Table structure for the STUDENT table:
 
b) Table structure for BOOK table:
 
c) Table structure for STAFF table:
 

d) Table structure for BILLOFLIB table:
 

7. CONSTRAINTS:

	The ‘STUID’ in the student table is the primary named as STUDENT_PK. It does not contain any child column.
The ‘BOOKID’ in the book table is the primary key named as SYS_C0013863. It also does not contain any child column.
The ‘STAFFID’ in the staff table is the primary key named as SYS_C0013912.
It also does not contain any child column.
The ‘BILLID’ in the billoflib table is the primary key named as SYS_C0013937.
It is having three child column which are ‘BOOKID’, ‘STAFFID’ and ‘STUID’, and their foreign key are ‘BOOK_FK’, ‘STAFFID_FK’ and ‘STU_FK’ respectively.

9. CLASS DIAGRAM:
 
FRONTEND : JAVA

10) JAVA CLASS USED:
DOMAIN OBJECT/ VALUE OBJECT:
Purpose of the object:
1.	To store the student details such as name, age, ID, DOB and phone number.
2.	To store the book price and all the sensitive information about book in the library.
3.	To store the attributes of the staff class such as Staff-Id, name, age, department, Phone number and DOB.
4.	To store the details of book class such as Book-ID, Book name, book mrp, and many more.
5.	To store the attribute to the Bill class like billID, billValue, billDate, student Id, staff id and book Id.

Package	Class name	Methods
com.birlasoft.projectOne.model	StudentVO	Constructors, getters and setters, toString().
com.birlasoft.projectOne.model	BookVO	Constructors, getters and setters, toString().
com.birlasoft.projectOne.model	StaffVO	Constructors, getters and setters, toString()
com.birlasoft.projectOne.model	BillVO	Constructors, getters and setters, toString()


SERVICE LAYER
Purpose of class: To validate the business requirements such as:
1.	To validate the staff/student id and phone number before storing it to the database.
2.	To validate the phone number length must be 10.
3.	To validate the staff Id not be null as well as the length must be 5.
4.	To validate the Date of Birth not to be null.
Package	Class name	Methods
com.birlasoft.projectOne.service	StudentBO/
StudentService	Public Boolean ValidPhoneNo (StudentVO)
com.birlasoft.projectOne.service	StaffBO/
StaffService	Public Boolean ValidationStaffId(StaffVO)

Public Boolean ValidationStaffPNo(StaffVO)

Public Boolean ValidationStaffDOB(StaffVO)

DATA ACCESS LAYER:
Purpose of class: To perform various functionalities that takes place between the frontend and the backend.
Package	Class name	Methods
com.birlasoft.projectOne.DAO	StudentDAO	private boolean CheckstuId(stuId)
Returns the last student ID such that it can be incremented during the next addition of student details.
public boolean addStudent(StudentVO)
Adds the new student details to the database for registration.
public boolean deleteStudent(StudentVO)
Delete the student details from the database from it’s id.
Public List<StudentVO> getstudentListById(stuId)
It fetches all the student details present in the database.
com.birlasoft.projectOne.DAO	StaffDAO	private boolean CheckstaffId(staffId)
Returns the last staff ID such that it can be incremented during the next addition of staff details.

public boolean addStaff(StaffVO)
Adds the new student details to the database for registration.

public boolean deleteStaff(StaffVO)
Delete the staff details from the database from it’s id.

public List<StaffVO> getstaffListBystaffId()
It fetches all the staff details present in the database.
com.birlasoft.projectOne.DAO	BookDAO	private boolean checkBookId(String bookId)
Returns the last book ID such that it can be incremented during the next addition of staff details.

public List<BookVO> getbookListByName()
It fetches all the book details present in the database.

public boolean addBook(BookVO)
Adds the new book details to the database for registration.

public boolean deleteBook(BookVO)
Delete the book details from the database from it’s id.

com.birlasoft.projectOne.DAO	BillDAO	public boolean addbill(BillVO, BookVO, StaffVO, StudentVO)
Adds the new bill details to the database for record.



UTILITY:
Purpose of class: To establish a connection between the frontend application and the backend application.
Package	Class name	Methods
com.birlasoft.digisole.util	DBConnection	publicstaticvoidloadDrivers()
Loads the required drivers for the connection
publicstatic Connection getConnection()
Returns a connection for the DAO process.
publicstaticvoidcloseConnection(Connection)
Close a connection given as parameter.





