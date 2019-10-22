package com.spring.iiht.core.iiht_springcore.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.iiht.main.Application;
import com.spring.iiht.model.Book;
import com.spring.iiht.repository.BookRepository;

import static org.mockito.Mockito.*;
import static junit.framework.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
@ContextConfiguration(classes=Application.class)
public class BookRepositoryTest {

	@MockBean
	BookRepository bookRepository;
	
	@Autowired
	TestEntityManager entityMgr;
	
	List<Book> allBooks = new ArrayList<Book>();
	
	@Before
	public void  setUp()
	{		
		
		Book b1 = new Book(new Long(1), "textbook1", 100, new Float(100.00));
		b1.setBookId(new Long(1));
		b1.setPublishDate(new Date());
		
		Book b2 = new Book(new Long(1), "textbook2", 200, new Float(200.00));
		b2.setBookId(new Long(2));
		b2.setPublishDate(new Date());
		
		Book b3 = new Book(new Long(2), "syllabusBook1", 100, new Float(100.00));
		b3.setBookId(new Long(3));
		b3.setPublishDate(new Date());
		
		Book b4 = new Book(new Long(2), "syllabusBook2", 50, new Float(49.99));
		b4.setBookId(new Long(4));
		b4.setPublishDate(new Date());
		
		allBooks.add(b1);
		allBooks.add(b2);
		allBooks.add(b3);
		allBooks.add(b4);
	}
	
	
	@After
	public void tearDown()
	{		
		for (Book book : allBooks) {
			entityMgr.remove(book);
		}
	}
	
	@Test
	public void testCreateBook()
	{
		Book b1 = new Book(new Long(1), "textbook1", 100, new Float(100.00));
		b1.setBookId(new Long(1));
		b1.setPublishDate(new Date());
		
		Book createdBook = b1;
		when(bookRepository.save(b1)).thenReturn(createdBook);
		Book result = bookRepository.save(b1);
	     
		verify(bookRepository, times(1)).save(b1);
	    verifyNoMoreInteractions(bookRepository);
		
		assertThat(result).isEqualTo(b1);
		
	}
	
	
	@Test
	public void testGetBookId()
	{
		Book lastBook = allBooks.get((allBooks.size()-1));
		Long lastBookId = lastBook.getBookId();
		
		
		when(bookRepository.getMaxBookId()).thenReturn(lastBookId);
		Long resultBookId = bookRepository.getMaxBookId();
	     
		verify(bookRepository, times(1)).getMaxBookId();
	    verifyNoMoreInteractions(bookRepository);
		
		assertThat(resultBookId).isEqualTo(lastBookId);
		assertEquals(lastBookId, resultBookId);
		
	}
	
	
	@Test
	public void testFindBookByTitle()
	{
		List<Book> bookResult = new ArrayList();
		Book resultBook = new Book(new Long(2), "syllabusBook1", 100, new Float(100.00));
		resultBook.setBookId(new Long(3));
		resultBook.setPublishDate(new Date());
		bookResult.add(resultBook);
		
		
		when(bookRepository.findByTitle("syllabusBook1")).thenReturn(bookResult);
		when(bookRepository.findByTitle("test")).thenReturn(null);
		
		List<Book> searchResult = bookRepository.findByTitle("syllabusBook1");
		List<Book> searchResult1 = bookRepository.findByTitle("test");
	     
		verify(bookRepository, times(1)).findByTitle("syllabusBook1");
		verify(bookRepository, times(1)).findByTitle("test");
	    verifyNoMoreInteractions(bookRepository);
		
		assertThat(bookResult).isEqualTo(searchResult);
		assertThat(bookResult).isNotEqualTo(searchResult1);
		
	}
}
