package com.birlasoft.projectOne.model;

public class BookVO {
	private String bookId;
	private String bookName;
	private String bookMRP;
	private String bookAuth;
	private String bookGenre;
	private String bookNumber;
public String getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}
	//
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookMRP() {
		return bookMRP;
	}
	public void setBookMRP(String bookMRP) {
		this.bookMRP = bookMRP;
	}
	public String getBookAuth() {
		return bookAuth;
	}
	public void setBookAuth(String bookAuth) {
		this.bookAuth = bookAuth;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
//
	
	

@Override
public String toString() {
	return "BookVO [bookId=" + bookId + ", bookName=" + bookName + ", bookMRP="
			+ bookMRP + ", bookAuth=" + bookAuth + ", bookGenre=" + bookGenre
			+ ", bookNumber=" + bookNumber + "]";
}
public BookVO(String bookId, String bookName, String bookMRP, String bookAuth,
		String bookGenre, String bookNumber) {
	super();
	this.bookId = bookId;
	this.bookName = bookName;
	this.bookMRP = bookMRP;
	this.bookAuth = bookAuth;
	this.bookGenre = bookGenre;
	this.bookNumber = bookNumber;
}
public BookVO() {
	super();
	// TODO Auto-generated constructor stub
}

}
