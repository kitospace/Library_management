package com.birlasoft.projectOne.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.birlasoft.projectOne.model.StaffVO;
import com.birlasoft.projectOne.util.DBOracleConnection;

public class StaffDAOImpl implements StaffDAO{
	//Add, Delete and View of Staff; 
	public boolean addStaff(StaffVO staff){
		Connection con = null;
		PreparedStatement pstat = null;
		
		boolean result = checkStaffId(staff.getStaffId());
		if(result){
			try{
				con = DBOracleConnection.getOracleConnection();
			}catch(SQLException e){
				System.out.println("Connection problem in staffDAO1 "+e);
			}
			try{
				String Query = "Insert into staff values(?,?,?,?,?,?)";
				pstat=con.prepareStatement(Query);
				
				pstat.setString(1, staff.getStaffId());
				pstat.setString(2, staff.getStaffName());
				pstat.setString(3, staff.getStaffAge());
				pstat.setString(4, staff.getStaffDpet());
				pstat.setString(5, staff.getStaffPNo());
				pstat.setString(6, staff.getStaffDOB());
				
				int updateResult = pstat.executeUpdate();
				if(updateResult>=1){
					result = true;
				}else{
					result = false;
				}
			}catch(SQLException e){
				System.out.println(" ");
			}catch(Exception e){
			      e.printStackTrace();
			   }finally{
			      try{
			         if(pstat!=null)
			            con.close();
			      }catch(SQLException se){
			      }
			      try{
			         if(con!=null)
			            con.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
			   }
		}else{
			result = false;
		}
		
		return result;
		
	}
	public boolean deleteStaff(StaffVO staff){
		Connection con = null;
		PreparedStatement pstat = null;
		
		boolean result = checkStaffId(staff.getStaffId());
		if(result){
			try{
				con = DBOracleConnection.getOracleConnection();
			}catch(Exception e){
				System.out.println("Connection problem in staffDAO3 "+e);
			}
			try{
				String Query = "DELETE FROM staff WHERE staffId=?";
				pstat=con.prepareStatement(Query);
				
				pstat.setString(1, staff.getStaffId());
				
				int updateResult = pstat.executeUpdate();
				if(updateResult>0){
					result = true;
				}else{
					result = false;
				}
			}catch(SQLException e){
				System.out.println("Connection problem in staffDAO4 "+e);
			}catch(Exception e){
			      e.printStackTrace();
			   }finally{
			      try{
			         if(pstat!=null)
			            con.close();
			      }catch(SQLException se){
			      }
			      try{
			         if(con!=null)
			            con.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
			   }
		}else{
			result = false;
		}
		
		return true;
		
	}
	
	public List<StaffVO> getstaffListBystaffId(String staffId){
		Connection con = null;
		PreparedStatement pstat = null;
		List<StaffVO> staffList = null;
		
		try{
			con = DBOracleConnection.getOracleConnection();
		}catch(SQLException e){
			System.out.println("Connection problem is "+e);
		}
		
		try{
			String Query = "Select * from staff where staffId = ?";
			pstat = con.prepareStatement(Query);
			pstat.setString(1, staffId);
			
			
			staffList= new ArrayList<StaffVO>();
			ResultSet rs =  pstat.executeQuery();
			while(rs.next()){  
				StaffVO staff = new StaffVO();
				String staffid= rs.getString(1);
				String staffName= rs.getString(2);
				String staffAge= rs.getString(3);
				String staffdpt= rs.getString(4);
				String staffPNo= rs.getString(5);
				String staffDOB= rs.getString(6);
				staff.setStaffId(staffid);
				staff.setStaffName(staffName);
				staff.setStaffAge(staffAge);
				staff.setStaffDpet(staffdpt);
				staff.setStaffPNo(staffPNo);
				staff.setStaffDOB(staffDOB);

				staffList.add(staff);
				}
	
		}catch(SQLException e){
			System.out.println("The Problem is "+e);
		}catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(pstat!=null)
		            con.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		return staffList;
		
	}

	private boolean checkStaffId(String staffId) {
		boolean staffIdresult = true;
		Connection con = null;
		PreparedStatement pstat = null;
		try{
			con = DBOracleConnection.getOracleConnection();
		}catch(SQLException e){
			System.out.println("Connection problem in staffDAO--"+e);
		}
		String Query = "Select staffId from staff";
		try{
			pstat = con.prepareStatement(Query);
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()){
				String staffid = rs.getString(1);
				if(staffid.equals(staffId)){
					staffIdresult = false;
					break;
				}
			}
			
		}catch(SQLException e){
			System.out.println("Connection problem in staffDAO=="+e);
		}catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(pstat!=null)
		            con.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		return staffIdresult;
	}
}
