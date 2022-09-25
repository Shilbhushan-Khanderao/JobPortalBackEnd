package com.JobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JobPortal.pojo.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer>{
	
//	@Query("From Application a where a.jobseeker.jobseekerid = ?1")
//	List<Application> getApplications(int jobseekerid);
	
	@Query(value = "Select * from application a Where a.jobseekerid = ?1",nativeQuery = true)
	List<Application> getApplications(int jobseekerid);
}
