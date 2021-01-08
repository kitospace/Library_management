package com.birlasoft.projectOne.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.birlasoft.projectOne.model.BookVO;
import com.birlasoft.projectOne.util.DBOracleConnection;

public class BookDAOImpl implements BookDAO {
	public List<BookVO> getbookListByName(String bookName){
		Connection con = null;
		PreparedStatement pstat = null;
		List<BookVO> bookList = null;
		
		try{
			con = DBOracleConnection.getOracleConnection();
		}catch(SQLException e){
			System.out.println("Connection problem is "+e);
		}
		
		try{
			String Query = "Select * from book where lower(bookName) = ?";
			pstat = con.prepareStatement(Query);
			pstat.setString(1, bookName);
			
			
			bookList= new ArrayList<BookVO>();
			ResultSet rs =  pstat.executeQuery();
			while(rs.next()){  
				BookVO book = new BookVO();
				String bookId = rs.getString(1);
				String bookname = rs.getString(2);
				String bookMrp = rs.getString(3);
				String bookAuth = rs.getString(4);
				String bookGenre = rs.getString(5);
				String bookNumber = rs.getString(6);
				book.setBookId(bookId);
				book.setBookName(bookname);
				book.setBookMRP(bookMrp);
				book.setBookAuth(bookAuth);
				book.setBookGenre(bookGenre);
				book.setBookNumber(bookNumber);

				bookList.add(book);
				}
	
		}catch(SQLException e){
			System.out.println("The Problem is "+e);
		}
		return bookList;
		
	}
	
	public boolean addBook(BookVO book){
		Connection con = null;
		PreparedStatement pstat = null;
		
		boolean result = checkBookId(book.getBookId());
		if(result){
			try{
				con = DBOracleConnection.getOracleConnection();
			}catch(SQLException e){
				System.out.println("Connection problem in BookDAO1 "+e);
			}
			try{
				String Query = "Insert into book values(?,?,?,?,?,?)";
				pstat=con.prepareStatement(Query);
				
				pstat.setString(1, book.getBookId());
				pstat.setString(2, book.getBookName());
				pstat.setString(3, book.getBookMRP());
				pstat.setString(4, book.getBookAuth());
				pstat.setString(5, book.getBookGenre());
				pstat.setString(6, book.getBookNumber());
				
				int updateResult = pstat.executeUpdate();
				if(updateResult>=1){
					result = true;
				}else{
					result = false;
				}
			}catch(SQLException e){
				System.out.println("Connection problem in BookDAO2 "+e);
			}
		}else{
			result = false;
		}
		
		return result;
		
	}
	

	private boolean checkBookId(String bookId) {
		boolean bookidResult=true;
		Connection con = null;
		PreparedStatement pstat = null;

		
		try{
			con=DBOracleConnection.getOracleConnection();
		}
		catch(SQLException e){
			System.out.println("The problem is"+e);
		}

		String Query = "Select bookId from book";
		
		try{
			pstat = con.prepareStatement(Query);
			ResultSet  result= pstat.executeQuery();
			while(result.next())
	          {
	        	  String bookid = result.getString(2);
	        	  if(bookid.equals(bookId))
	        	  {
	        		  bookidResult=false;
	        		  break;
	        	  }
	        	  
	          }
		}
		catch(SQLException e){
			e.printStackTrace();		
			}
		
		return bookidResult;	
		}

	public boolean deleteBook(BookVO book){
		Connection con = null;
		PreparedStatement pstat = null;
		
		boolean result = checkBookId(book.getBookId());
		if(result){
			try{
				con = DBOracleConnection.getOracleConnection();
			}catch(SQLException e){
				System.out.println("Connection problem in bookDAO "+e);
			}
			try{
				String Query = "DELETE FROM book WHERE bookid=?";
				pstat=con.prepareStatement(Query);
				
				pstat.setString(1, book.getBookId());
				
				int updateResult = pstat.executeUpdate();
				if(updateResult>0){
					result = true;
				}else{
					result = false;
				}
			}catch(SQLException e){
				e.printStackTrace();
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
	}
