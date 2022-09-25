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

import com.JobPortal.dao.AdminDao;
import com.JobPortal.daoimpl.Response;
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
	public ResponseEntity<?> checkUser(@RequestBody Admin admin) {
		
		Admin a = daoImpl.checkCredentials(admin);
		
		if (a == null) {
			return Response.error("User not Found");
		}
		System.out.println(a);
		return Response.success(a);
		
//		if (a != null) {
//			System.out.println(a);
//			return ResponseEntity.ok(a);
//		}
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

	}
	
	//http://localhost:9009/admin/addAdmin
	@PostMapping(value = "/addAdmin")
	public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {

		if (daoImpl.AddAdmin(admin)) {
			return Response.success(admin);
		}
		else {
			return Response.error("User Addition Failed");
		}
	}
	
	//http://localhost:9009/admin/update
	@PutMapping(value = "/update")
	public ResponseEntity<?> update(@RequestBody Admin admin)
	{
		if(daoImpl.editAdmin(admin)) 
			return Response.success(admin);
		else
			return Response.error("Updation Failed");
	}
	
	//http://localhost:9009/admin/delete?adminid=1
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Map<String, String>> delete(@RequestParam("adminid") String adminid) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		int id = Integer.parseInt(adminid);
		
		if(daoImpl.deleteAdmin(id))
			hmap.put("msg", "deleted");
		else
			hmap.put("msg", "failed");
		
		return ResponseEntity.ok(hmap);
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
	public ResponseEntity<Map<String, String>> deleteJobProvider(@RequestBody JobProvider jp) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		if (daoImpl.deleteJobProvider(jp)) {
			hmap.put("msg", "deleted");
		}
		else {
			hmap.put("msg", "failed");
		}
		return ResponseEntity.ok(hmap);
	}
	
		//http://localhost:9009/admin/deletejs?jobSeekerid=3
		@DeleteMapping(value = "/deletejs")
		public ResponseEntity<Map<String, String>> deleteJobSeeker(@RequestBody Jobseeker js) {
			
			HashMap<String, String> hmap = new HashMap<>();
			
			if (daoImpl.deleteJobSeeker(js)) {
				hmap.put("msg", "deleted");
			}
			else {
				hmap.put("msg", "failed");
			}
			return ResponseEntity.ok(hmap);
		}
		
		//http://localhost:9009/admin/viewprofile/1
		@GetMapping(value = "/viewprofile/{adminid}")
		public Admin viewAdmin(@PathVariable("adminid") int adminid){
			
			Admin j = daoImpl.viewProfile(adminid);
			return j;
		}
}
