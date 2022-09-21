package com.JobPortal.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobPortal.dao.JobDao;
import com.JobPortal.pojo.Job;
import com.JobPortal.repository.JobRepository;


@Service
public class JobDaoImpl implements JobDao{
	
	@Autowired
	private JobRepository repository;
	
	@Override
	public List<Job> getAllJobs() {
		
		List<Job> lst = new ArrayList<>();
		
		try {
			repository.findAll().forEach(lst::add);
			return lst;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Job searchJob(int jobid) {
		try {
			
			Optional<Job> opt = repository.findById(jobid); 
			
			if(opt.isPresent()) {
				Job pr = opt.get();
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




