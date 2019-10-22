package com.spring.iiht.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Book {
	
	@Id
	@Column(name="book_id")
	Long bookId;
	
	@Column(name="subject_id")
	Long subjectId;
	
	@Column(name="title")
	String title;
	
	@Column(name="price")
	Float price;

	@Column(name="volume")
	int volume;
	
	@Column(name="publish_date")
	Date publishDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="subject_id", updatable=false, insertable=false, nullable=false )
	@NotFound(action=NotFoundAction.IGNORE)
	Subject subject;
	
	public Book(Long subjectId, String title, int volume, Float price) {
		this.subjectId = subjectId;
		this.title = title;
		this.volume = volume;
		this.price = price;
	}
	
	public Book() {
		//default constructor
	}
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
