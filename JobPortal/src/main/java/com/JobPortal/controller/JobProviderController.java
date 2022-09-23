package com.JobPortal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.JobPortal.dao.JobProviderDao;
import com.JobPortal.daoimpl.Response;
import com.JobPortal.pojo.Job;
import com.JobPortal.pojo.JobProvider;


@RestController
@RequestMapping("/jobprovider")
@CrossOrigin("*")
public class JobProviderController {

	@Autowired
	private JobProviderDao daoImpl;
	
	//http://localhost:9009/jobprovider/login
	@PostMapping(value = "/login")
	public ResponseEntity<?> checkUser(@RequestBody JobProvider jp) {
		
		JobProvider jProvider = daoImpl.checkCredentials(jp);
		
		if(jProvider == null) {
			return Response.error("User not found");
		}
		System.out.println(jProvider);
		return Response.success(jProvider);
	}
	
	//http://localhost:9009/jobprovider/addjobprovider
	@PostMapping(value = "/addjobprovider")
	public ResponseEntity<?> addJobCandidate(@RequestBody JobProvider jp) {
		
		if (daoImpl.SignUp(jp)) {
			return Response.success(jp);
		}
		else {
			return Response.error("User addition failed");
		}
	}
	
		//http://localhost:9009/jobprovider/update
		@PutMapping(value = "/update")
		public ResponseEntity<?> update(@RequestBody JobProvider jp)
		{			
			if(daoImpl.editJobProvider(jp)) 
				return Response.success(jp);
			else
				return Response.error("Updation Failed");
		}
		
		//http://localhost:9009/jobprovider/delete?adminid=1
		@DeleteMapping(value = "/delete")
		public ResponseEntity<Map<String, String>> deleteJobProvider(@RequestParam("jobproviderid") String jpid) {
			
			HashMap<String, String> hmap = new HashMap<>();
			
			int id = Integer.parseInt(jpid);
			
			if(daoImpl.deleteJobProvider(id))
				hmap.put("msg", "deleted");
			else
				hmap.put("msg", "failed");
			
			return ResponseEntity.ok(hmap);
		}
	
	//http://localhost:9009/jobprovider/addjobpost
	@PostMapping(value = "/addjobpost")
	public ResponseEntity<?> addJobPost(@RequestBody Job job) {
		
		if (daoImpl.addJobPost(job)) {
			return Response.success(job);
		}
		else {
			return Response.error("Job Addition Failed");
		}
	}
	
	//http://localhost:9009/jobprovider/editjobpost
	@PutMapping(value = "/editjobpost")
	public ResponseEntity<?> update(@RequestBody Job job)
	{
		
		if(daoImpl.editJobPost(job)) 
			return Response.success(job);
		else
			return Response.error("Update Failed");
	}
	
	//http://localhost:9009/jobprovider/deletejobpost?jobid=1
	@DeleteMapping(value = "/deletejobpost")
	public ResponseEntity<Map<String, String>> delete(@RequestParam("jobid") String jobid) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		int id = Integer.parseInt(jobid);
		
		if(daoImpl.deleteJobPost(id))
			hmap.put("msg", "deleted");
		else
			hmap.put("msg", "failed");
		
		return ResponseEntity.ok(hmap);
	}
	
	//http://localhost:9009/jobprovider/viewprofile/1
	@GetMapping(value = "/viewprofile/{jobproviderid}")
	public JobProvider viewJobProvider(@PathVariable("jobproviderid") int jobproviderid){
		
		JobProvider j = daoImpl.viewProfile(jobproviderid);
		return j;
	}
	
	//http://localhost:9009/jobprovider/view/1
	@GetMapping(value = "/view/{jobid}")
	public Job viewJob(@PathVariable("jobid") int jobid){
		
		Job j = daoImpl.viewJobPost(jobid);
		return j;
	}
}
