package com.JobPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JobPortal.dao.JobDao;
import com.JobPortal.pojo.Job;

@RestController
@RequestMapping("/job")
@CrossOrigin("*")
public class JobController {

	@Autowired
	private JobDao daoImpl;
	
	
	/*
	 *  request url :  http://localhost:9009/getalljobs
	 *  request method : GET
	 */
	@GetMapping(value = "/getalljobs")
	public List<Job> returnAllJobs() {
	
		List<Job> lst = daoImpl.getAllJobs();
		return lst;
	}
	
	//http://localhost:9009/searchjob/5	 
	@GetMapping(value = "/searchjob/{id}")
	public Job getJob(@PathVariable("id") int job_Id) {
		
		Job pr = daoImpl.searchJob(job_Id);
		return pr;
	}
}
