package com.JobPortal.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.JobPortal.pojo.JobProvider;

public interface JobProviderRepository extends CrudRepository<JobProvider, Integer>{

	@Query("From JobProvider p Where p.username = ?1 and p.password = ?2")
	JobProvider login(String username,String password);
}
