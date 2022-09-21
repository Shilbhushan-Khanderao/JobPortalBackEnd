package com.JobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JobPortal.pojo.Jobseeker;

@Repository
public interface JobseekerRepository extends JpaRepository<Jobseeker, Integer> {

	@Query("From Jobseeker s Where s.username = ?1 and s.password = ?2")
	Jobseeker login(String username,String password);
}
