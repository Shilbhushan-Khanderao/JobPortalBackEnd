package com.JobPortal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.JobPortal.pojo.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{

	@Query("From Admin a Where a.username = ?1 and a.password = ?2")
	Admin login(String username,String password);
}