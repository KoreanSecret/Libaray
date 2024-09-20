package com.example.demo.jpa;


import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.Book;

@Repository //데이터베이스와 연동 쿼리를 실행할 인터페이스
//하이버네이트는 이 인터페이스를 상속 받아서
//데이터베이스와 연동하는 쿼리를 실행하는 클래스를 구현 할 것임

public interface JpaBookRepository extends JpaRepository<Book, String>{

	  //bookid 컬럼의 값이 일치하는 데이터를 조회하는 메서드
	public List <Book> findByBookid(String bookid);
	
	
	// value에 설정한 쿼리를 실행하고 조회결과를 리턴
	//실행한 쿼리 :value = "select * from book order by bookid desc" 
	//오라클 쿼리 실행 : nativeQuery = true
	@Query(value = "select * from book order by bookid desc" , nativeQuery = true)
	public List<Book> selectAllBookSortBookid();
}
