package com.JobPortal.controller;

import java.util.HashMap;

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

import com.JobPortal.dao.JobProviderDao;
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
	public HashMap<String, String> checkUser(@RequestBody JobProvider jp) {
		
		HashMap<String,String> hmap = new HashMap<>();
		
		if(daoImpl.checkCredentials(jp)) {
			hmap.put("msg","Login Success");
		}
		else {
			hmap.put("msg", "Login Failed");
		}
		return hmap;
	}
	
	//http://localhost:9009/jobprovider/addjobprovider
	@PostMapping(value = "/addjobprovider")
	public HashMap<String, String> addJobCandidate(@RequestBody JobProvider jp) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		if (daoImpl.SignUp(jp)) {
			hmap.put("msg", "Register Success");
		}
		else {
			hmap.put("msg", "Register Failed");
		}
		return hmap;
	}
	
		//http://localhost:9009/jobprovider/update
		@PutMapping(value = "/update")
		public HashMap<String, String> update(@RequestBody JobProvider jp)
		{
			HashMap<String, String> hmap = new HashMap<>();
			
			if(daoImpl.editJobProvider(jp)) 
				hmap.put("msg", "Updated successfully");
			else
				hmap.put("msg", "Updation failed");
			
			return hmap;
		}
		
		//http://localhost:9009/jobprovider/delete?adminid=1
		@DeleteMapping(value = "/delete")
		public HashMap<String, String> deleteJobProvider(@RequestParam("jobproviderid") String jpid) {
			
			HashMap<String, String> hmap = new HashMap<>();
			
			int id = Integer.parseInt(jpid);
			
			if(daoImpl.deleteJobProvider(id))
				hmap.put("msg", "Deleted successfully");
			else
				hmap.put("msg", "Deletion failed");
			
			return hmap;
		}
	
	//http://localhost:9009/jobprovider/addjobpost
	@PostMapping(value = "/addjobpost")
	public HashMap<String, String> addJobPost(@RequestBody Job job) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		if (daoImpl.addJobPost(job)) {
			hmap.put("msg", "Job Added Successfully");
		}
		else {
			hmap.put("msg", "Job Addition Failed");
		}
		return hmap;
	}
	
	//http://localhost:9009/jobprovider/editjobpost
	@PutMapping(value = "/editjobpost")
	public HashMap<String, String> update(@RequestBody Job job)
	{
		HashMap<String, String> hmap = new HashMap<>();
		
		if(daoImpl.editJobPost(job)) 
			hmap.put("msg", "Updated successfully");
		else
			hmap.put("msg", "Updation failed");
		
		return hmap;
	}
	
	//http://localhost:9009/jobprovider/deletejobpost?jobid=1
	@DeleteMapping(value = "/deletejobpost")
	public HashMap<String, String> delete(@RequestParam("jobid") String jobid) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		int id = Integer.parseInt(jobid);
		
		if(daoImpl.deleteJobPost(id))
			hmap.put("msg", "Job deleted successfully");
		else
			hmap.put("msg", "Job deletion failed");
		
		return hmap;
	}
	
	//http://localhost:9009/jobprovider/view/1
	@GetMapping(value = "/view/{jobid}")
	public Job viewJob(@PathVariable("jobid") int jobid){
		
		Job j = daoImpl.viewJobPost(jobid);
		return j;
	}
}
