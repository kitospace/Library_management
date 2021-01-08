package com.birlasoft.projectOne.main;

import java.util.List;
import java.util.Scanner;

import com.birlasoft.projectOne.DAO.BookDAO;
import com.birlasoft.projectOne.DAO.BookDAOImpl;
import com.birlasoft.projectOne.model.BookVO;

public class BookMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BookDAO bookDAO = new BookDAOImpl();
		try{
		System.out.println("This is Book Record Database.");
		while(true){
			System.out.println("Enter book name to know about them");
			String bookNm = sc.nextLine();
			
			List<BookVO> bookList = bookDAO.getbookListByName(bookNm);
	
			for(BookVO book :bookList)
			{
				System.out.println(" ");
				System.out.println("Book Id : "+book.getBookId());
				System.out.println("Book Name : "+book.getBookName());
				System.out.println("Book MRP : "+book.getBookMRP());
				System.out.println("Book Authur : "+book.getBookAuth());
				System.out.println("Book Genre : "+book.getBookGenre());
				System.out.println("Number of Books : "+book.getBookNumber());
				System.out.println(" ");
			}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}}	
		
		
		
		
	
