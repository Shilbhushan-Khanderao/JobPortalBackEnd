package com.JobPortal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.JobPortal.daoimpl.Response;
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
		
	//http://localhost:9009/admin/login
	@PostMapping(value = "/login")
	public ResponseEntity<?> checkUser(@RequestBody Jobseeker js){
		Jobseeker jseeker = daoImpl.checkCredentials(js);
		
		if(js == null) {
			return Response.error("JobSeeker not found");
		}
			System.out.println(js);
			return Response.success(jseeker);
	}
		
	//http://localhost:9009/jobseeker/addjobseeker
	@PostMapping(value = "/addjobseeker")
	public ResponseEntity<?> addJobCandidate(@RequestBody Jobseeker js) {
	
		
		if (daoImpl.AddJobseeker(js)) {
			return Response.success(js);
		}
		else {
			return Response.error("Addition Failed");
		}
	}
	
	//http://localhost:9009/jobseeker/update
	@PutMapping(value = "/update")
	public ResponseEntity<?> update(@RequestBody Jobseeker js)
	{		
		if(daoImpl.editJobSeeker(js)) 
			return Response.success(js);
		else
			return Response.error("Update Failed");
	}
	
	//http://localhost:9009/jobseeker/delete?jobseekerid=1
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Map<String, String>> deleteJobSeeker(@RequestParam("jobseekerid") String jpid) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		int id = Integer.parseInt(jpid);
		
		if(daoImpl.deleteJobSeeker(id))
			hmap.put("msg", "deleted");
		else
			hmap.put("msg", "failed");
		
		return ResponseEntity.ok(hmap);
	}
	
	//http://localhost:9009/jobprovider/viewjobprovider/1
	@GetMapping(value = "/viewprofile/{jobseekerid}")
	public Jobseeker viewJobProvider(@PathVariable("jobseekerid") int jobseekerid){
		
		Jobseeker j = daoImpl.viewProfile(jobseekerid);
		return j;
	}
	
	//http://localhost:9009/jobseeker/apply
	@PostMapping(value = "/apply")
	public ResponseEntity<?> applyJob(@RequestBody Application appl) {
		
		if (daoImpl.applyForJob(appl)) {
			return Response.success(appl);
		}
		else {
			return Response.error("Application failed");
		}
	}
	
	//http://localhost:9009/jobseeker/delete?applicationid=1
	@DeleteMapping(value = "/deleteappl")
	public ResponseEntity<Map<String, String>> deleteApplication(@RequestParam("applicationid") String applid) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		int id = Integer.parseInt(applid);
		
		if(daoImpl.deleteAppl(id))
			hmap.put("msg", "deleted");
		else
			hmap.put("msg", "failed");
		
		return ResponseEntity.ok(hmap);
	}
	
	//http://localhost:9009/jobseeker/getappliedjobs/2
	@GetMapping(value = "/getappliedjobs/{id}")
	public List<Application> getAppliedJobs(@PathVariable("id") int id) {
		
		List<Application> lst = daoImpl.getAppliedJobs(id);
		return lst;
	}
	
	//http://localhost:9009/jobseeker/addeducation
	@PostMapping(value = "/addeducation")
	public ResponseEntity<?> addEducation(@RequestBody Education edu) {
		
		if (daoImpl.addEducation(edu)) {
			return Response.success(edu);
		}
		else {
			return Response.error("Addition Failed");
		}
	}
	
	//http://localhost:9009/jobseeker/updateeducation
	@PutMapping(value = "/updateeducation")
	public ResponseEntity<?> updateEducation(@RequestBody Education education)
	{		
		if(daoImpl.editEducation(education)) 
			return Response.success(education);
		else
			return Response.error("Updation failed");
	}
	
	//http://localhost:9009/jobseeker/deleteeducation?jobseekerid=1
	@DeleteMapping(value = "/deleteeducation")
	public ResponseEntity<Map<String, String>> deleteEducation(@RequestParam("educationid") String eduid) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		int id = Integer.parseInt(eduid);
		
		if(daoImpl.deleteEducation(id))
			hmap.put("msg", "deleted");
		else
			hmap.put("msg", "failed");
		
		return ResponseEntity.ok(hmap);
	}
	
	//http://localhost:9009/jobseeker/addexp
	@PostMapping(value = "/addexp")
	public ResponseEntity<?> addExperience(@RequestBody Experience experience) {
		
		if (daoImpl.AddExperience(experience)) {
			return Response.success(experience);
		}
		else {
			return Response.error("Addition Failed");
		}
	}
	
	//http://localhost:9009/jobseeker/updateexp
	@PutMapping(value = "/updateexp")
	public ResponseEntity<?> updateExperience(@RequestBody Experience experience)
	{		
		if(daoImpl.editExperience(experience)) 
			return Response.success(experience);
		else
			return Response.error("Update Failed");
	}
	
	//http://localhost:9009/jobseeker/deleteexp?jobseekerid=1
	@DeleteMapping(value = "/deleteexp")
	public ResponseEntity<Map<String, String>> deleteExperience(@RequestParam("expid") String expid) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		int id = Integer.parseInt(expid);
		
		if(daoImpl.deleteJobSeeker(id))
			hmap.put("msg", "deleted");
		else
			hmap.put("msg", "failed");
		
		return ResponseEntity.ok(hmap);
	}
}
