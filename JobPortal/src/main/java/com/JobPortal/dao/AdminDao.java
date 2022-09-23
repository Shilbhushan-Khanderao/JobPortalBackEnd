package com.JobPortal.dao;

import java.util.List;

import com.JobPortal.pojo.Admin;
import com.JobPortal.pojo.JobProvider;
import com.JobPortal.pojo.Jobseeker;

public interface AdminDao {

	Admin checkCredentials(Admin admin);
	
	//CRUD Operations
	boolean AddAdmin(Admin admin);
	boolean editAdmin(Admin admin);
	boolean deleteAdmin(int adminid);
	Admin viewProfile(int adminid);
	
	//admin methods
	List<Admin> getAllAdmins();
	List<JobProvider> getJobProviderList();
	List<Jobseeker> getJobSeekerList();
	boolean deleteJobProvider(JobProvider jp);
	boolean deleteJobSeeker(Jobseeker js);
}
