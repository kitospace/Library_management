package com.birlasoft.projectOne.DAO;

import java.util.List;

import com.birlasoft.projectOne.model.BookVO;



public interface BookDAO {
	public List<BookVO> getbookListByName(String bookName);
	public boolean addBook(BookVO book);
	public boolean deleteBook(BookVO book);
}
