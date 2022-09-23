package com.JobPortal.daoimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobPortal.dao.JobProviderDao;
import com.JobPortal.pojo.Job;
import com.JobPortal.pojo.JobProvider;
import com.JobPortal.repository.JobProviderRepository;
import com.JobPortal.repository.JobRepository;

@Service
public class JobProviderDaoImpl implements JobProviderDao {

	@Autowired
	private JobProviderRepository repository;
	
	@Autowired
	private JobRepository jobrepository;
	
	@Override
	public JobProvider checkCredentials(JobProvider jp) {
		try {
			JobProvider jProvider = repository.login(jp.getUsername(),jp.getPassword());

			if (jProvider != null) {
				
				if (jProvider.getUsername().equals(jp.getUsername()) && jProvider.getPassword().equals(jp.getPassword()))
					return jProvider;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean SignUp(JobProvider jp) {
		try {
			Optional<JobProvider> opt = repository.findById(jp.getJobproviderid());

			if (opt.isPresent()) {
				return false;
			} else {
				repository.save(jp);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editJobProvider(JobProvider jp) {
		try {
			Optional<JobProvider> opt = repository.findById(jp.getJobproviderid());
			
			if (opt.isPresent()) {
				repository.save(jp);
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
	public boolean deleteJobProvider(int jobid) {
		try {
			Optional<JobProvider> opt = repository.findById(jobid);
			
			if (opt.isPresent()) {
				repository.deleteById(jobid);
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
	public boolean addJobPost(Job job) {
		
		try {
			jobrepository.save(job);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editJobPost(Job job) {
		
		try {
			Optional<Job> opt = jobrepository.findById(job.getJobid());
			
			if(opt.isPresent()) {
				jobrepository.save(job);
				return true;
			}
			else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteJobPost(int jobid) {
		
		try {
			Optional<Job> opt = jobrepository.findById(jobid);
			
			if(opt.isPresent()) {
				jobrepository.deleteById(jobid);
				return true;
			}
			else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Job viewJobPost(int  jobid) {
		try {
			Optional<Job> opt = jobrepository.findById(jobid); 
			
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

	@Override
	public JobProvider viewProfile(int jpid) {
		try {
			Optional<JobProvider> opt = repository.findById(jpid); 
			
			if(opt.isPresent()) {
				JobProvider pr = opt.get();
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
