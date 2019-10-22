package com.spring.iiht.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.iiht.model.Book;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Query(name="getMaxBookId", value="select max(book_id) from Book", nativeQuery=true)
	public Long getMaxBookId();
	
	@Query(name="findByTitle", value="select b1 from Book b1 where UPPER(b1.title) = :title", nativeQuery=false)
	public List<Book> findByTitle(@Param(value = "title") String title);

}
