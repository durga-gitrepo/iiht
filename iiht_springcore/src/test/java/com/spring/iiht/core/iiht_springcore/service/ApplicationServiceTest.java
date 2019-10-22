package com.spring.iiht.core.iiht_springcore.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.iiht.main.Application;
import com.spring.iiht.model.Book;
import com.spring.iiht.model.Subject;
import com.spring.iiht.repository.BookRepository;
import com.spring.iiht.repository.SubjectRepository;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
@ContextConfiguration(classes=Application.class)
public class ApplicationServiceTest {
	
	@MockBean
	SubjectRepository subjectRepository;
	
	List<Subject> allSubjects = new ArrayList<Subject>();
	List<Book> allBooks = new ArrayList<Book>();
	
	@MockBean
	BookRepository bookRepository;
	
	@Autowired
	TestEntityManager entityMgr;
	
	@Before
	public void  setUp()
	{
		allSubjects.add(new Subject(new Long(1), "textSubject", 100));
		allSubjects.add(new Subject(new Long(2), "newSubject", 200));
		allSubjects.add(new Subject(new Long(3), "test3", 100));
		
		for (Subject subject : allSubjects) {
			entityMgr.persist(subject);
		}
		
		Book b1 = new Book(new Long(1), "textbook1", 100, new Float(100.00));
		b1.setBookId(new Long(1));
		b1.setPublishDate(new Date());
		
		Book b2 = new Book(new Long(1), "textbook2", 200, new Float(200.00));
		b1.setBookId(new Long(2));
		b1.setPublishDate(new Date());
		
		Book b3 = new Book(new Long(2), "syllabusBook1", 100, new Float(100.00));
		b1.setBookId(new Long(3));
		b1.setPublishDate(new Date());
		
		Book b4 = new Book(new Long(2), "syllabusBook2", 50, new Float(49.99));
		b1.setBookId(new Long(4));
		b1.setPublishDate(new Date());
		
		allBooks.add(b1);
		allBooks.add(b2);
		allBooks.add(b3);
		allBooks.add(b4);
	}
	
	
	@After
	public void tearDown()
	{
		for (Subject subject : allSubjects) {
			entityMgr.remove(subject);
		}
		
		for (Book book : allBooks) {
			entityMgr.remove(book);
		}
	}
	
	@Test
	public void testGetAllSubjects() throws Exception
	{			
		Mockito.when(this.subjectRepository.findAll()).thenReturn(allSubjects);
		List<Subject> result = subjectRepository.findAll();
		
		assertThat(allSubjects).isEqualTo(result);
		
	}
	
	@Test
	public void testGetSubject() throws Exception
	{
		List<Subject> resultList = new ArrayList<Subject>();
		resultList.add(allSubjects.get(0));
		resultList.add(allSubjects.get(2));
		
		Mockito.when(this.subjectRepository.findByDuration(100)).thenReturn(resultList);
		List<Subject> result = subjectRepository.findByDuration(100);
		assertThat(resultList).isEqualTo(result);
	}
	
	@Test
	public void testAddSubject() throws Exception
	{
		Subject s = new Subject(new Long(4), "test4", 100);
		Mockito.when(this.subjectRepository.saveAndFlush(s)).thenReturn(s);
		Subject s1 =  subjectRepository.saveAndFlush(s);
		
		assertThat(s).isEqualTo(s1);
	}
	
	/*@Test
	public void testDeleteSubject() throws Exception
	{
		Mockito.when(this.subjectRepository.findById(new Long(1)).get()).thenReturn(allSubjects.get(0));
		Optional<Subject> subjectOpt = subjectRepository.findById(new Long(1));
		if(subjectOpt != null)
		{
			Subject subject = subjectOpt.get();
			if(subject != null)
			{
				System.out.println("Deleting subject :"+ subject.getSubjectTitle());
				subjectRepository.delete(subject);
			}
		}
	}*/
		
	@Test
	public void testGetAllBooks() throws Exception
	{
		Mockito.when(this.bookRepository.findAll()).thenReturn(allBooks);
		List<Book> resultList = bookRepository.findAll();
		assertThat(resultList).isEqualTo(allBooks);
	}
	
	@Test
	public void testFindBook() throws Exception
	{
		List<Book> bookResult = new ArrayList<Book>();
		bookResult.add(allBooks.get(3));
		
		Mockito.when(this.bookRepository.findByTitle("syllabusBook2")).thenReturn(bookResult);
		List<Book> result  = bookRepository.findByTitle("syllabusBook2");
		assertThat(bookResult).isEqualTo(result);
		

		List<Book> newResult  = bookRepository.findByTitle("syllabusBook3");
		assertThat(bookResult).isNotEqualTo(newResult);
	}
	
	@Test
	public void testAddBook() throws Exception
	{
		Long mockMaxBookId = new Long(4);
		Mockito.when(this.bookRepository.getMaxBookId()).thenReturn(mockMaxBookId);
		Long maxBookId = bookRepository.getMaxBookId();
		assertThat(mockMaxBookId).isEqualTo(maxBookId);
		
		maxBookId = maxBookId+1;
		assertThat(mockMaxBookId).isNotEqualTo(maxBookId);
		
		Book b5 = new Book(new Long(3), "syllabusBook3", 300, new Float(149.99));
		b5.setBookId(maxBookId);
		b5.setPublishDate(new Date());
		
		Mockito.when(this.bookRepository.saveAndFlush(b5)).thenReturn(b5);
		Book resultBook = bookRepository.saveAndFlush(b5);
		assertThat(resultBook).isEqualTo(b5);
	}
}
