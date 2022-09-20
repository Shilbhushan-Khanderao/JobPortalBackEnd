package com.JobPortal.dao;

import java.util.List;

import com.JobPortal.pojo.Application;
import com.JobPortal.pojo.Education;
import com.JobPortal.pojo.Experience;
import com.JobPortal.pojo.Jobseeker;



public interface JobseekerDao {
	
	boolean checkCredentials(Jobseeker jobseeker);
	
	//CRUD methods
	boolean AddJobseeker(Jobseeker jobseeker);
	boolean editJobSeeker(Jobseeker jobseeker);
	boolean deleteJobSeeker(int jobseekerid);
	
	//Jobseeker Methods
	boolean applyForJob(Application appl);
	boolean deleteAppl(int appid);
	Jobseeker viewProfile(Jobseeker jobseeker);
	List<Application> getAppliedJobs(Jobseeker jobseeker);
	
	//Education methods
	boolean addEducation(Education edu);
	boolean editEducation(Education education);
	boolean deleteEducation(int educationid);
	List<Education> getEducationList();
	
	//Experience methods
	boolean AddExperience(Experience experience);
	boolean editExperience(Experience experience);
	boolean deleteExperience(int Experienceid);
	List<Experience> getExperienceList();
}
