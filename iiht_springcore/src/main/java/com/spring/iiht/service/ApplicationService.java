package com.spring.iiht.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.iiht.model.Book;
import com.spring.iiht.model.Subject;
import com.spring.iiht.repository.BookRepository;
import com.spring.iiht.repository.SubjectRepository;

@Service
public class ApplicationService {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	
	public List<Subject> getAllSubjects() throws Exception
	{
		List<Subject> allSubjects = new ArrayList<Subject>();
		allSubjects = subjectRepository.findAll();
		return allSubjects;
	}
	
	public List<Subject> getSubject(Integer duration) throws Exception
	{
		List<Subject> allSubjects = new ArrayList<Subject>();
		allSubjects = subjectRepository.findByDuration(duration);
		return allSubjects;
	}
	
		
	public void addSubject(Subject newSubject) throws Exception
	{
		subjectRepository.saveAndFlush(newSubject);
	}
	
	public void deleteSubject(Long subjectId) throws Exception
	{
		Optional<Subject> subjectOpt = subjectRepository.findById(subjectId);
		if(subjectOpt != null)
		{
			Subject subject = subjectOpt.get();
			if(subject != null)
			{
				System.out.println("Deleting subject :"+ subject.getSubjectTitle());
				subjectRepository.delete(subject);
			}
		}
	}
		
	public List<Book> getAllBooks() throws Exception
	{
		List<Book> allBooks = new ArrayList<Book>();
		allBooks = bookRepository.findAll();
		return allBooks;
	}
	
	public List<Book> findBook(String bookTitle) throws Exception
	{
		List<Book> allBooks = new ArrayList<Book>();
		allBooks = bookRepository.findByTitle(bookTitle);
		return allBooks;
	}
	
	public void addBook(Book book) throws Exception
	{
		Long maxBookId = bookRepository.getMaxBookId();
		maxBookId = maxBookId+1;
		System.out.println("Max Book Id :"+maxBookId );
		book.setBookId(maxBookId);
		book.setPublishDate(new Date());
		bookRepository.saveAndFlush(book);
	}
	
	public void deleteBook(Long bookId) throws Exception
	{
		Optional<Book> bookOpt = bookRepository.findById(bookId);
		if(bookOpt != null)
		{
			Book book = bookOpt.get();
			System.out.println("Book subject >>>> : "+book.getSubject().getSubjectTitle());
			if(book != null)
			{
				System.out.println("Deleting book  :"+ book.getTitle());
				bookRepository.delete(book);
			}
		}
	}
}
