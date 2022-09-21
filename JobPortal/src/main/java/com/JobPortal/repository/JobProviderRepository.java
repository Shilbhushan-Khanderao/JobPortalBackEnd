package com.JobPortal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JobPortal.pojo.JobProvider;

@Repository
public interface JobProviderRepository extends JpaRepository<JobProvider, Integer>{

	@Query("From JobProvider p Where p.username = ?1 and p.password = ?2")
	JobProvider login(String username,String password);
}
