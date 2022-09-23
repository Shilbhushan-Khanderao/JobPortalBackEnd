package com.JobPortal.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobPortal.dao.AdminDao;
import com.JobPortal.pojo.Admin;
import com.JobPortal.pojo.JobProvider;
import com.JobPortal.pojo.Jobseeker;
import com.JobPortal.repository.AdminRepository;
import com.JobPortal.repository.JobProviderRepository;
import com.JobPortal.repository.JobseekerRepository;

@Service
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private AdminRepository repository;
	
	@Autowired
	private JobProviderRepository repositoryJP;
	
	@Autowired
	private JobseekerRepository repositoryJS;
	
	@Override
	public Admin checkCredentials(Admin admin) {
		try {
			Admin adm = repository.login(admin.getUsername(),admin.getPassword());
			
			if (adm != null) {
				
				if (adm.getUsername().equals(admin.getUsername()) && adm.getPassword().equals(admin.getPassword())) {
					return adm;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean AddAdmin(Admin admin) {
		try {
			Optional<Admin> opt = repository.findById(admin.getAdminid());
			
			if (opt.isPresent()) {
				return false;
			}
			else {
				repository.save(admin);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public boolean editAdmin(Admin admin) {
		try {
			Optional<Admin> opt = repository.findById(admin.getAdminid());
			
			if (opt.isPresent()) {
				repository.save(admin);
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAdmin(int adminid) {
		try {
			Optional<Admin> opt = repository.findById(adminid);
			
			if (opt.isPresent()) {
				repository.deleteById(adminid);
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Admin> getAllAdmins() {
		
		List<Admin> lst = new ArrayList<>();
		
		try {
			repository.findAll().forEach(lst::add);
			return lst;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<JobProvider> getJobProviderList() {
		
		List<JobProvider> lst = new ArrayList<>();
		
		try {
			repositoryJP.findAll().forEach(lst::add);
			return lst;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Jobseeker> getJobSeekerList() {
		
		List<Jobseeker> lst = new ArrayList<>();
		
		try {
			repositoryJS.findAll().forEach(lst::add);
			return lst;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteJobProvider(JobProvider jp) {
		try {
		
			Optional<JobProvider> opt = repositoryJP.findById(jp.getJobproviderid());
			
			if (opt.isPresent()) {
				repositoryJP.deleteById(jp.getJobproviderid());
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteJobSeeker(Jobseeker js) {
		try {
			
			Optional<Jobseeker> opt = repositoryJS.findById(js.getJobseekerid());
			
			if (opt.isPresent()) {
				repositoryJP.deleteById(js.getJobseekerid());
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Admin viewProfile(int adminid) {
		try {
			Optional<Admin> opt = repository.findById(adminid); 
			
			if(opt.isPresent()) {
				Admin pr = opt.get();
				return pr;
			}
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
