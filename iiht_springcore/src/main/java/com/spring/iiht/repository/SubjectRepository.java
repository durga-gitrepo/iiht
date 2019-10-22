package com.spring.iiht.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.iiht.model.Subject;

@Repository("subjectRepository")
public interface SubjectRepository extends JpaRepository<Subject, Long>{

	@Query(name="findByDuration", value="select sub from Subject sub where sub.durationHrs = :duration", nativeQuery=false)
	public List<Subject> findByDuration(@Param(value = "duration") int duration);
}
