package com.JobPortal.dao;

import java.util.List;

import com.JobPortal.pojo.Job;



public interface JobDao {

	//query operations

	List<Job> getAllJobs();
	Job searchJob(int job_Id);	
}
