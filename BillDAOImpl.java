package com.birlasoft.projectOne.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.birlasoft.projectOne.model.BillVO;
import com.birlasoft.projectOne.model.BookVO;
import com.birlasoft.projectOne.model.StaffVO;
import com.birlasoft.projectOne.model.StudentVO;
import com.birlasoft.projectOne.util.DBOracleConnection;

public class BillDAOImpl implements BillDAO{
	public boolean addbill(BillVO bill, BookVO book, StaffVO staff, StudentVO stud){
		Connection con = null;
		PreparedStatement pstat = null;
		boolean result = checkbillId(bill.getBILLID());
		if(result){
			try{
				con = DBOracleConnection.getOracleConnection();
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				String Query = "INSERT INTO BILLOFLIB VALUES(?,?,?,?,?,?)";
				pstat = con.prepareStatement(Query);
				
				pstat.setLong(1, bill.getBILLID());
				pstat.setString(2, bill.getBILLDATE());
				pstat.setLong(3, bill.getBILLVALUE());
				pstat.setString(4, book.getBookId());
				pstat.setString(5, staff.getStaffId());
				pstat.setLong(6, stud.getStuId());
				
				int resultUpdate = pstat.executeUpdate();
				if(resultUpdate>=1){
					result = true;
				}else{
					result = false;
				}
			}catch(Exception e){
				System.out.println("");
			}
	}
		return result;
	}

	private boolean checkbillId(int billid) {
		boolean billIdResult = true;
		Connection con = null; 
		PreparedStatement pstat = null;
		try{
			con = DBOracleConnection.getOracleConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		String Query = "Select billId from billofLib";
		
		try{
			pstat = con.prepareStatement(Query);
			ResultSet  result= pstat.executeQuery();
			while(result.next())
	          {
	        	  String billoid = result.getString(2);
	        	  if(billoid.equals(billid))
	        	  {
	        		  billIdResult=false;
	        		  break;
	        	  }
	        	  
	          }
		}
		catch(SQLException e){
			System.out.println("");
		}
		
		return billIdResult;
	}
	}

