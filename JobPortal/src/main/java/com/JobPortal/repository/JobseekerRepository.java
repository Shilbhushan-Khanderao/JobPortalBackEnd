package com.JobPortal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.JobPortal.pojo.Jobseeker;

public interface JobseekerRepository extends CrudRepository<Jobseeker, Integer> {

	@Query("From Jobseeker s Where s.username = ?1 and s.password = ?2")
	Jobseeker login(String username,String password);
}
