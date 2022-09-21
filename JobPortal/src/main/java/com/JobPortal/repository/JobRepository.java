package com.JobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JobPortal.pojo.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

}

