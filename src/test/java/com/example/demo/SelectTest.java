package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.jpa.JpaBookRepository;
import com.example.demo.vo.Book;

@SpringBootTest
public class SelectTest {

	
	@Autowired // JapBookRepository 인터페이스를 상속 받아서
	//SQL 쿼리를 실행하는 메서드가 구현된 클래스 객체를 자동으로 대입 받을 변수
	// 해당 객체는 업캐스팅으로 부모타입 인터페이스 변수에 저장
	JpaBookRepository jpaBook;
	
	@Test
	void select() {
		//japBook.findAll() :Book 테이블의 모든 레코드 조회
		List<Book> allBook= jpaBook.findAll();
		System.out.println("JpaBookRepository:allBook()="+allBook);
		
		//jpaBook.findById("9") : jpaBook.findByID("9") Primary key bookid 9인 레코드 조회
		Optional<Book> book = jpaBook.findById("9");
		
		System.out.println("JpaBookRepository:findById()="+book);
	}
}
