package com.example.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.jpa.JpaBookRepository;
import com.example.demo.vo.Book;

@SpringBootTest
public class InsertDeleteUpdateTest {
    @Autowired //JpaBookRepository 인터페이스를 상속 받아서
    //SQL 쿼리를 실해앟는 메서드가 구현된 클래스 객체를 자동으로 대입 받을 변수
    // 해당 객체는 업캐스팅으로 부모타입 인터페이스 변수에 저장
    JpaBookRepository jpaBook;
    
    @Test
    void insertUpdateDelete() {
    	//데이터베이스 Insert할 Book 객체
    	Book book01=new Book();
    	//데이터베이스 Insert할 아이디
    	book01.setBookid("99");
    	//데이터베이스 Insert할 제목
    	book01.setBookname("스프링부트 기초");
    	//데이터베이스 Insert할 가격
    	book01.setPrice("45000");
    	//데이터베이스 Insert할 출판사
    	book01.setPublisher("한국폴리텍");
    	//데이터베이스 채정보 추가
    	jpaBook.save(book01);
    	//jpaBook.findById("9") : jpaBook.findById("9") Primary Key bookid 9인 레코드 조회
    	Optional<Book> selectList = jpaBook.findById("9");
    	//데이터베이스 Update 할 Book 객체
    	Book book02=selectList.get();
    	book02.setPrice("88000");
    	//데이터베이스 bookid가 9인 책의 가격 88000 원으로 수정 -> bookid가 존재하면수정
    	jpaBook.save(book02);
    	
    	//Book 테이블 bookid 가 4인 책 삭제
    	jpaBook.deleteById("4");
    }
    
    
	
	
	
}
