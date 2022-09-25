package com.JobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JobPortal.pojo.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer>{

	@Query(value = "Select * from education e Where e.jobseekerid = ?1",nativeQuery = true)
	public List<Education> getEducation(int jobseekerid);
}