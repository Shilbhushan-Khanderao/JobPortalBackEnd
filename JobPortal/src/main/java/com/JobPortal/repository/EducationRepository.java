package com.JobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JobPortal.pojo.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer>{

}