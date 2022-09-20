package com.JobPortal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JobPortal.pojo.Job;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> {

}

