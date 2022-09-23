package com.JobPortal.dao;

import com.JobPortal.pojo.Job;
import com.JobPortal.pojo.JobProvider;

public interface JobProviderDao {

	//Login Method
	public JobProvider checkCredentials(JobProvider jp);
	
	//CRUD methods
	public boolean SignUp(JobProvider jp);
	public boolean editJobProvider(JobProvider jp);
	public boolean deleteJobProvider(int jobid);
	
	//Job Creation Methods
	public boolean addJobPost(Job job);
	public boolean editJobPost(Job job);
	public boolean deleteJobPost(int jobid);
	JobProvider viewProfile(int jpid);
	//Job Method
	Job viewJobPost(int jobid);
}