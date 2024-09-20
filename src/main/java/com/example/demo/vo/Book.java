package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
	
	@Entity(name="book") // 하이버네이트가 조회할 테이블명
	public class Book {
    @Id //Primary key 속성
    //책 아이디를 저장할 속성
    private String bookid;
    // 책 제목을 저장할 속성
    private String bookname;
    //출판사를 저장할 속성
    private String publisher;
    //가격을 저장할 속성
    private String price;
    
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", publisher=" + publisher + ", price=" + price
				+ "]";
	}
    
}
