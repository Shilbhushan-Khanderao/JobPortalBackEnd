package com.JobPortal.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JobPortal.dao.JobseekerDao;
import com.JobPortal.pojo.Application;
import com.JobPortal.pojo.Education;
import com.JobPortal.pojo.Experience;
import com.JobPortal.pojo.Jobseeker;

@RestController
@RequestMapping("/jobseeker")
@CrossOrigin("*")
public class JobSeekerController {

	@Autowired
	private JobseekerDao daoImpl;
		
	@PostMapping(value = "/login")
	public HashMap<String, String> checkUser(@RequestBody Jobseeker js){
		HashMap<String, String> hmap = new HashMap<>();
		
		if(daoImpl.checkCredentials(js)) {
			hmap.put("msg", "Login Success");
		}
		else {
			hmap.put("msg", "Login Failed");
		}
		return hmap;
	}
		
	//http://localhost:9009/jobseeker/addjobseeker
	@PostMapping(value = "/addjobseeker")
	public HashMap<String, String> addJobCandidate(@RequestBody Jobseeker js) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		if (daoImpl.AddJobseeker(js)) {
			hmap.put("msg", "Register Success");
		}
		else {
			hmap.put("msg", "Register Failed");
		}
		return hmap;
	}
	
	//http://localhost:9009/jobseeker/update
	@PutMapping(value = "/update")
	public HashMap<String, String> update(@RequestBody Jobseeker js)
	{
		HashMap<String, String> hmap = new HashMap<>();
		
		if(daoImpl.editJobSeeker(js)) 
			hmap.put("msg", "Updated successfully");
		else
			hmap.put("msg", "Updation failed");
		
		return hmap;
	}
	
	//http://localhost:9009/jobseeker/delete?jobseekerid=1
	@DeleteMapping(value = "/delete")
	public HashMap<String, String> deleteJobSeeker(@RequestParam("jobseekerid") String jpid) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		int id = Integer.parseInt(jpid);
		
		if(daoImpl.deleteJobSeeker(id))
			hmap.put("msg", "Deleted successfully");
		else
			hmap.put("msg", "Deletion failed");
		
		return hmap;
	}
	
	//http://localhost:9009/jobseeker/apply
	@PostMapping(value = "/apply")
	public HashMap<String, String> applyJob(@RequestBody Application appl) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		if (daoImpl.applyForJob(appl)) {
			hmap.put("msg", "Applied Successfully");
		}
		else {
			hmap.put("msg", "Appllication Failed");
		}
		return hmap;
	}
	
	//http://localhost:9009/jobseeker/delete?applicationid=1
	@DeleteMapping(value = "/deleteappl")
	public HashMap<String, String> deleteApplication(@RequestParam("applicationid") String applid) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		int id = Integer.parseInt(applid);
		
		if(daoImpl.deleteAppl(id))
			hmap.put("msg", "Deleted successfully");
		else
			hmap.put("msg", "Deletion failed");
		
		return hmap;
	}
	
	//http://localhost:9009/jobseeker/getappliedjobs/2
	@GetMapping(value = "/getappliedjobs/{id}")
	public List<Application> getAppliedJobs(@PathVariable("id") int id) {
		
		List<Application> lst = daoImpl.getAppliedJobs(id);
		return lst;
	}
	
	//http://localhost:9009/jobseeker/addeducation
	@PostMapping(value = "/addeducation")
	public HashMap<String, String> addEducation(@RequestBody Education edu) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		if (daoImpl.addEducation(edu)) {
			hmap.put("msg", "Addition Success");
		}
		else {
			hmap.put("msg", "Addition Failed");
		}
		return hmap;
	}
	
	//http://localhost:9009/jobseeker/updateeducation
	@PutMapping(value = "/updateeducation")
	public HashMap<String, String> updateEducation(@RequestBody Education education)
	{
		HashMap<String, String> hmap = new HashMap<>();
		
		if(daoImpl.editEducation(education)) 
			hmap.put("msg", "Updated successfully");
		else
			hmap.put("msg", "Updation failed");
		
		return hmap;
	}
	
	//http://localhost:9009/jobseeker/deleteeducation?jobseekerid=1
	@DeleteMapping(value = "/deleteeducation")
	public HashMap<String, String> deleteEducation(@RequestParam("educationid") String eduid) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		int id = Integer.parseInt(eduid);
		
		if(daoImpl.deleteEducation(id))
			hmap.put("msg", "Deleted successfully");
		else
			hmap.put("msg", "Deletion failed");
		
		return hmap;
	}
	
	//http://localhost:9009/jobseeker/addexp
	@PostMapping(value = "/addexp")
	public HashMap<String, String> addExperience(@RequestBody Experience experience) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		if (daoImpl.AddExperience(experience)) {
			hmap.put("msg", "Addition Success");
		}
		else {
			hmap.put("msg", "Addition Failed");
		}
		return hmap;
	}
	
	//http://localhost:9009/jobseeker/updateexp
	@PutMapping(value = "/updateexp")
	public HashMap<String, String> updateExperience(@RequestBody Experience experience)
	{
		HashMap<String, String> hmap = new HashMap<>();
		
		if(daoImpl.editExperience(experience)) 
			hmap.put("msg", "Updated successfully");
		else
			hmap.put("msg", "Updation failed");
		
		return hmap;
	}
	
	//http://localhost:9009/jobseeker/deleteexp?jobseekerid=1
	@DeleteMapping(value = "/deleteexp")
	public HashMap<String, String> deleteExperience(@RequestParam("expid") String expid) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		int id = Integer.parseInt(expid);
		
		if(daoImpl.deleteJobSeeker(id))
			hmap.put("msg", "Deleted successfully");
		else
			hmap.put("msg", "Deletion failed");
		
		return hmap;
	}
}
