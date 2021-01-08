package com.birlasoft.projectOne.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.birlasoft.projectOne.model.StudentVO;
import com.birlasoft.projectOne.util.DBOracleConnection;

public class StudentDAOImpl implements StudentDAO {
	public boolean addStudent(StudentVO student){
		
		Connection con=null;
		PreparedStatement pstat = null;
		
		boolean result = CheckstuId(student.getStuId());
		
		if(result){
			try{
				con = DBOracleConnection.getOracleConnection();
			}
			catch(SQLException e)
			{
				System.out.println("Problem in Connection"+e);
			}
			try{
				String query = "INSERT INTO STUDENT values(?,?,?,?,?)";
				
				pstat=con.prepareStatement(query);
				
				pstat.setInt(1, student.getStuId());
				pstat.setString(2, student.getStuName());
				pstat.setString(3, student.getStuAge());
				pstat.setString(4, student.getStuNum());
				pstat.setString(5, student.getStuDOB());
				
				int updateResult = pstat.executeUpdate();
				if(updateResult>=1){
					result=true;
				}else{
					result=false;
				}
			}
			catch(SQLException e){
				System.out.println("The problem with inserting data"+e);
			}
			}else{
				result=false;
			}
		
		return result;
	}

	private boolean CheckstuId(int stuId) {
		boolean custidResult=true;
		Connection con = null;
		PreparedStatement pstat = null;

		
		try{
			con=DBOracleConnection.getOracleConnection();
		}
		catch(SQLException e){
			System.out.println("The problem is"+e);
		}

		String stuIdQuery = "Select stuId from student";
		
		try{
			pstat = con.prepareStatement(stuIdQuery);
			ResultSet  result= pstat.executeQuery();
			while(result.next())
	          {
	        	  String stuid = result.getString(2);
	        	  if(stuid.equals(stuId))
	        	  {
	        		  custidResult=false;
	        		  break;
	        	  }
	        	  
	          }
		}
		catch(SQLException e){
			System.out.println("");
		}
		
		return custidResult;
	}
	
	public boolean deleteStudent(StudentVO student){
		Connection con = null;
		PreparedStatement pstat = null;
		
		boolean result = CheckstuId(student.getStuId());
		if(result){
			try{
				con = DBOracleConnection.getOracleConnection();
			}catch(Exception e){
				System.out.println("Connection problem in studentDAO "+e);
			}
			try{
				String Query = "DELETE FROM student WHERE stuId=?";
				pstat=con.prepareStatement(Query);
				
				pstat.setLong(1, student.getStuId());
				
				int updateResult = pstat.executeUpdate();
				if(updateResult>0){
					result = true;
				}else{
					result = false;
				}
			}catch(SQLException e){
				System.out.println("Connection problem in studentDAO.. "+e);
			}
		}else{
			result = false;
		}
		
		return true;
		
	}
	
	public List<StudentVO> getstudentListById(int stuId){
		Connection con = null;
		PreparedStatement pstat = null;
		List<StudentVO> stuList = null;
		
		try{
			con = DBOracleConnection.getOracleConnection();
		}catch(SQLException e){
			System.out.println("Connection problem is "+e);
		}
		
		try{
			String Query = "Select * from student where stuId = ?";
			pstat = con.prepareStatement(Query);
			pstat.setLong(1, stuId);
			
			
			stuList= new ArrayList<StudentVO>();
			ResultSet rs =  pstat.executeQuery();
			while(rs.next()){  
				StudentVO stud = new StudentVO();
				int id = rs.getInt(1);
				String stuname = rs.getString(2);
				String stuAge = rs.getString(3);
				String stuPNo = rs.getString(4);
				String stuDOB = rs.getString(5);
				
				stud.setStuId(id);
				stud.setStuName(stuname);
				stud.setStuAge(stuAge);
				stud.setStuNum(stuPNo);
				stud.setStuDOB(stuDOB);

				stuList.add(stud);
				}
	
		}catch(SQLException e){
			System.out.println("The Problem is "+e);
		}
		return stuList;
		
	}
}
