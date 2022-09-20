package com.JobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.JobPortal.pojo.Application;

public interface ApplicationRepository extends CrudRepository<Application, Integer>{
	
	@Query("From Application a where a.jobseeker.jobseekerid = ?1")
	List<Application> getApplications(int jobseekerid);
}
