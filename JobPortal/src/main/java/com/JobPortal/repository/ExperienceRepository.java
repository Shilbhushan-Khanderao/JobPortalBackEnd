package com.JobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JobPortal.pojo.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>{
	
	@Query(value = "Select * from experience e Where e.jobseekerid = ?1",nativeQuery = true)
	public List<Experience> getExperience(int jobseekerid);
}
