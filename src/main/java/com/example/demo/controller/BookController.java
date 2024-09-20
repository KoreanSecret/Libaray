package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.jpa.JpaBookRepository;
import com.example.demo.vo.Book;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BookController {
	@Autowired // JpaBookRepository 인터페이스를 상속 받아서 SQL 쿼리를 실행하는 메서드가 구현된 클래스 객체를 자동으로 대입 받을 변수
	// 해당 객체는 업캐스팅으로 부모타입 인터퍼ㅔ이스 변수에 저장
	JpaBookRepository jpaBook;

	// 웹브라우저에서 http://localhost:8080/insertBookForm 입력 했을 때 실행
	@RequestMapping(value = "/insertBookForm")
	public ModelAndView insertBook1() {
		ModelAndView mav = new ModelAndView();
		// html 페이지의 파일명 insertBook.html 페이지 실행
		mav.setViewName("insertBook");

		return mav;

	}

	// 웹브라우저에서 http://localhost8080:insertBookControl 입력 했을때 실행
	@RequestMapping(value = "/insertBookControl")
	public ModelAndView insertBook2(HttpServletRequest request) {

		// 입력값을 리턴 받아서 변수에 저장
		String num = request.getParameter("bookid");
		String name = request.getParameter("bookname");
		String pub = request.getParameter("publisher");
		String pri = request.getParameter("price");

		// 데이터베이스에 저장할 정보를 속성에 저장하고 있는 Book 개체 생성
		Book book = new Book();
		book.setBookid(num);
		book.setBookname(name);
		book.setPublisher(pub);
		book.setPrice(pri);

		// book 객체의 속성 값을 데이터베이스에 저장
		jpaBook.save(book);

		ModelAndView mav = new ModelAndView();

		// html 페이지에서 출력할 메세지
		mav.addObject("result", "도서 정보가 추가되었습니다");
		// html 페이지의 파일명 insertBookResult.html 페이지 실행
		mav.setViewName("insertBookResult");

		return mav;

	}

	@RequestMapping(value="selectBook")
	public ModelAndView viewBook1(HttpServletRequest request) {
		//조회하고자 하는 책 1권의 bookid 리턴
		String bookid=request.getParameter("bookid");
		//bookid(Primary Key)가 일치하는 책 정보를 저회해서 변수 b에 저장
		Book b = jpaBook.getById(bookid);
		
		ModelAndView mav = new ModelAndView();
		
		//조회한 책 정보를 html 페이지로 전송
		mav.addObject("book", b);
		
		//selectBookOne.html 페이지로 이동
		mav.setViewName("selectBookOne");
		
		return mav;
		
	}
	
	@RequestMapping(value="updateBookForm")
	public ModelAndView updateBook1(HttpServletRequest request) {
		//수정하고자 하는 책 1권의 bookid 리턴
		String bookid=request.getParameter("bookid");
		
		//bookid(Primary Key)가 일치하는 책 정보를 조회해서 변수 b에 저장
		Book b = jpaBook.getById(bookid);
		ModelAndView mav = new ModelAndView();
		
		//조회한 책 정보를 html 페이지로 전송
		mav.addObject("book", b);
		
		//updateBook.html페이지로 이동
		mav.setViewName("updateBook");
		return mav;
		
				
	}
	
	//웹브라우저에서 http://localhost:8080/updateBookControl 입력 했을때 실행
	@RequestMapping(value="/updateBookControl")
	public ModelAndView updateBook2(HttpServletRequest request) {
		
		//입력값을 리턴 받아서 변수에 저장
		
		String num=request.getParameter("bookid");
		String name=request.getParameter("bookname");
		String pub=request.getParameter("publisher");
		String pri=request.getParameter("price");
		
		//데이터베이스에 수정할 정보를 속성에 저장하고 있는 Book 개체 생성
		
		Book book = new Book();
		book.setBookid(num);
		book.setBookname(name);
		book.setPublisher(pub);
		book.setPrice(pri);
		
		//bookid가 일치하는 book 개체의 속성 값을 데이터베이스에 수정
		jpaBook.save(book);
		
		ModelAndView mav = new ModelAndView();
		
		//html 페이지에서 출력할 메세지
		mav.addObject("result", "도서 정보가 수정 되었습니다");
		//html 페이지의 파일명 updateBookResult.html 페이지 실행
		mav.setViewName("updateBookResult");
		
		return mav;
	}

	//웹브라우저에서 http://localhost:8080/selectAll 입력 했을 때 실행
	@RequestMapping(value="/")
	public ModelAndView allBook1() {

		//모든 책 정보를 조회해서 변수 allList에 저장
		List<Book> allList = jpaBook.selectAllBookSortBookid();
		
		ModelAndView mav = new ModelAndView();
		
		//조회한 모든 책 정보를 html 페이지로 전송
		mav.addObject("allBook", allList);
		
		//bookList.html 페이지로 이동
		mav.setViewName("selectBookAll");
		
		return mav;
		
	}
}
