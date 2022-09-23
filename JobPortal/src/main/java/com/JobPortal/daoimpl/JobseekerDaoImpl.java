package com.JobPortal.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JobPortal.dao.JobseekerDao;
import com.JobPortal.pojo.Application;
import com.JobPortal.pojo.Education;
import com.JobPortal.pojo.Experience;
import com.JobPortal.pojo.Jobseeker;
import com.JobPortal.repository.ApplicationRepository;
import com.JobPortal.repository.EducationRepository;
import com.JobPortal.repository.ExperienceRepository;
import com.JobPortal.repository.JobseekerRepository;

@Service
public class JobseekerDaoImpl implements JobseekerDao {

	@Autowired
	private JobseekerRepository repository;
	
	@Autowired
	private ApplicationRepository appRepository;
	
	@Autowired
	private EducationRepository eduRepository;
	
	@Autowired
	private ExperienceRepository expRepository;

	@Override
	public Jobseeker checkCredentials(Jobseeker jobseeker) {
		try {
			Jobseeker js = repository.login(jobseeker.getUsername(), jobseeker.getPassword());

			if (js != null) {

				if (js.getUsername().equals(jobseeker.getUsername()) && js.getPassword().equals(jobseeker.getPassword())) {
					return js;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean AddJobseeker(Jobseeker jobseeker) {
		try {
			Optional<Jobseeker> opt = repository.findById(jobseeker.getJobseekerid());

			if (opt.isPresent()) {
				return false;
			} else {
				repository.save(jobseeker);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editJobSeeker(Jobseeker jobseeker) {
		try {
			Optional<Jobseeker> opt = repository.findById(jobseeker.getJobseekerid());
			
			if (opt.isPresent()) {
				repository.save(jobseeker);
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
	public boolean deleteJobSeeker(int jobseekerid) {
		try {
			Optional<Jobseeker> opt = repository.findById(jobseekerid);
			
			if (opt.isPresent()) {
				repository.deleteById(jobseekerid);
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
	public boolean applyForJob(Application appl) {
		try {
			
			Optional<Application> opt = appRepository.findById(appl.getApplicationid());
	
			if (opt.isPresent()) {
				return false;
			}
			else {
				appRepository.save(appl);
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAppl(int appid) {
		try {
			Optional<Application> opt = appRepository.findById(appid);
			
			if (opt.isPresent()) {
				appRepository.deleteById(appid);
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
	public Jobseeker viewProfile(int jobseekerid) {
		try {
			Optional<Jobseeker> opt = repository.findById(jobseekerid); 
			
			if(opt.isPresent()) {
				Jobseeker pr = opt.get();
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
	public List<Application> getAppliedJobs(int jsid) {
		List<Application> lst = new ArrayList<>();
		
		try {
			lst = appRepository.getApplications(jsid);
			return lst;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addEducation(Education education) {
		try {
			eduRepository.save(education);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editEducation(Education education) {
		try {
			Optional<Education> opt = eduRepository.findById(education.getEducationid());
			
			if(opt.isPresent()) {
				eduRepository.save(education);
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
	public boolean deleteEducation(int educationid) {
		try {
			Optional<Education> opt = eduRepository.findById(educationid);
			
			if(opt.isPresent()) {
				eduRepository.deleteById(educationid);
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
	public List<Education> getEducationList() {
		List<Education> lst = new ArrayList<>();
		
		try {
			eduRepository.findAll().forEach(lst::add);
			return lst;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean AddExperience(Experience experience) {
		try {
			expRepository.save(experience);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editExperience(Experience experience) {
		try {
			Optional<Experience> opt = expRepository.findById(experience.getExpid());
			
			if(opt.isPresent()) {
				expRepository.save(experience);
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
	public boolean deleteExperience(int experienceid) {
		try {
			Optional<Experience> opt = expRepository.findById(experienceid);
			
			if(opt.isPresent()) {
				expRepository.deleteById(experienceid);
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
	public List<Experience> getExperienceList() {
		List<Experience> lst = new ArrayList<>();
		
		try {
			expRepository.findAll().forEach(lst::add);
			return lst;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
