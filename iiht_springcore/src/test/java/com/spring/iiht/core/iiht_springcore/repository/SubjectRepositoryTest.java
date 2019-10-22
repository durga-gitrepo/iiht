package com.spring.iiht.core.iiht_springcore.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import com.spring.iiht.model.Subject;
import com.spring.iiht.repository.SubjectRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
@ContextConfiguration(classes=Application.class)
public class SubjectRepositoryTest {

	@MockBean
	SubjectRepository subjectRepository;
	
	@Autowired
	TestEntityManager entityMgr;
	
	List<Subject> allSubjects = new ArrayList<Subject>();
	
	@Before
	public void  setUp()
	{
		allSubjects.add(new Subject(new Long(1), "textSubject", 100));
		allSubjects.add(new Subject(new Long(2), "newSubject", 200));
		allSubjects.add(new Subject(new Long(3), "test3", 100));
		
		for (Subject subject : allSubjects) {
			entityMgr.persist(subject);
		}
		
	}
	
	@After
	public void tearDown()
	{
		for (Subject subject : allSubjects) {
			entityMgr.remove(subject);
		}
	}
	
	@Test
	public void testCreateSubject()
	{
		Subject s1 =(new Subject(new Long(1), "textSubject", 100));
		Subject createdSubject = s1;
		
		when(subjectRepository.save(s1)).thenReturn(createdSubject);
		Subject result = subjectRepository.save(s1);
	     
		verify(subjectRepository, times(1)).save(s1);
	    verifyNoMoreInteractions(subjectRepository);
		
		assertThat(result).isEqualTo(s1);
		
	}
}
