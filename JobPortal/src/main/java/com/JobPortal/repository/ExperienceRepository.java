package com.JobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JobPortal.pojo.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>{
	
}
