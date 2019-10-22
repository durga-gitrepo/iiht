package com.spring.iiht.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
	
	@Id
	@Column(name="subject_id")
	Long subjectId;
	
	@Column(name="subject_title")
	String subjectTitle;
	
	@Column(name="duration_hrs")
	int durationHrs;
	
	public Subject(Long subjectId, String subjectTitle, int durationHrs) {
		this.subjectId = subjectId;
		this.subjectTitle = subjectTitle;
		this.durationHrs = durationHrs;
	}
	
	public Subject(){
		//default constructor
	}
	
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public int getDurationHrs() {
		return durationHrs;
	}
	public void setDurationHrs(int durationHrs) {
		this.durationHrs = durationHrs;
	}
}
