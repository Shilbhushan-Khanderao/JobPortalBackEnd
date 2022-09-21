package com.JobPortal.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.JobPortal.dao.AdminDao;
import com.JobPortal.pojo.Admin;
import com.JobPortal.pojo.JobProvider;
import com.JobPortal.pojo.Jobseeker;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private AdminDao daoImpl;
	
	//http://localhost:9009/admin/login
	@PostMapping(value = "/login")
	public HashMap<String, String> checkUser(@RequestBody Admin admin) {
		
		HashMap<String,String> hmap = new HashMap<>();
		
		if(daoImpl.checkCredentials(admin)) {
			hmap.put("msg","Login Success");
		}
		else {
			hmap.put("msg", "Login Failed");
		}
		return hmap;
	}
	
	//http://localhost:9009/admin/addAdmin
	@PostMapping(value = "/addAdmin")
	public HashMap<String, String> addAdmin(@RequestBody Admin admin) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		if (daoImpl.AddAdmin(admin)) {
			hmap.put("msg", "Register Success");
		}
		else {
			hmap.put("msg", "Register Failed");
		}
		return hmap;
	}
	
	//http://localhost:9009/admin/update
	@PutMapping(value = "/update")
	public HashMap<String, String> update(@RequestBody Admin admin)
	{
		HashMap<String, String> hmap = new HashMap<>();
		
		if(daoImpl.editAdmin(admin)) 
			hmap.put("msg", "Admin updated successfully");
		else
			hmap.put("msg", "Admin updation failed");
		
		return hmap;
	}
	
	//http://localhost:9009/admin/delete?adminid=1
	@DeleteMapping(value = "/delete")
	public HashMap<String, String> delete(@RequestParam("adminid") String adminid) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		int id = Integer.parseInt(adminid);
		
		if(daoImpl.deleteAdmin(id))
			hmap.put("msg", "Admin deleted successfully");
		else
			hmap.put("msg", "Admin deletion failed");
		
		return hmap;
	}
	
	//http://localhost:9009/admin/getalladmin
	@GetMapping(value = "/getalladmin")
	public List<Admin> getAllAdmin() {
	
		List<Admin> lst = daoImpl.getAllAdmins();
		return lst;
	}
	
	//http://localhost:9009/admin/getalljobprovider
	@GetMapping(value = "/getalljobprovider")
	public List<JobProvider> getAllJobProvider() {
	
		List<JobProvider> lst = daoImpl.getJobProviderList();
		return lst;
	}
	
	//http://localhost:9009/admin/getalljobseeker
	@GetMapping(value = "/getalljobseeker")
	public List<Jobseeker> getAllCandidate(){
		List<Jobseeker> lst = daoImpl.getJobSeekerList();
		return lst;
	}
	
	//http://localhost:9009/admin/deletejp?jobProviderid=2
	@DeleteMapping(value = "/deletejp")
	public HashMap<String, String> deleteJobProvider(@RequestBody JobProvider jp) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		if (daoImpl.deleteJobProvider(jp)) {
			hmap.put("msg", "Employer Deletion Successful");
		}
		else {
			hmap.put("msg", "Employer Deletion Successful");
		}
		return hmap;
	}
	
		//http://localhost:9009/admin/deletejs?jobSeekerid=3
		@DeleteMapping(value = "/deletejs")
		public HashMap<String, String> deleteJobSeeker(@RequestBody Jobseeker js) {
			
			HashMap<String, String> hmap = new HashMap<>();
			
			if (daoImpl.deleteJobSeeker(js)) {
				hmap.put("msg", "Cadidate Deletion Successful");
			}
			else {
				hmap.put("msg", "Cadidate Deletion Successful");
			}
			return hmap;
		}
}
