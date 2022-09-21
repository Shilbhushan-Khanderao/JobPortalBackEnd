package com.JobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JobPortal.pojo.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Query("From Admin a Where a.username = ?1 and a.password = ?2")
	Admin login(String username,String password);
}