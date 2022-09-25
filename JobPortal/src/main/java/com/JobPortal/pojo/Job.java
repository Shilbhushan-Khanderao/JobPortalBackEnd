package com.JobPortal.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Job")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobid")
	private int jobid;
	
	@Column(name = "jobTitle")
	private String jobTitle;
	
	@Column(name = "salary")
	private int salary;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "jobCategory")
	private String jobCategory;
	
	@Column(name = "jobDescription")
	private String jobDescription;
	
	@Column(name = "totalVacancy")
	private String totalVacancy;
	
	@Column(name = "postDate")
	private String postDate;
	
	@Column(name = "postStatus")
	private String postStatus;
	
	@OneToMany(mappedBy = "job",targetEntity = Application.class,cascade = CascadeType.ALL)
	private List<Application> applications;
	
	public Job() {
		
	}
	
	public Job(String jobTitle, int salary, String location, String jobCategory, String jobDescription,
			String totalVacancy, String postDate, String postStatus) {
		this.jobTitle = jobTitle;
		this.salary = salary;
		this.location = location;
		this.jobCategory = jobCategory;
		this.jobDescription = jobDescription;
		this.totalVacancy = totalVacancy;
		this.postDate = postDate;
		this.postStatus = postStatus;
	}

	public int getJobid() {
		return jobid;
	}
	
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getJobCategory() {
		return jobCategory;
	}
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getTotalVacancy() {
		return totalVacancy;
	}
	public void setTotalVacancy(String totalVacancy) {
		this.totalVacancy = totalVacancy;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getPostStatus() {
		return postStatus;
	}
	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}
	
	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return jobid + " : " + jobTitle + " : " + salary + " : " +
				location + " : " + jobCategory + " : " + jobDescription + " : " +
				totalVacancy + " : " + postDate + " : " + postStatus;
	}
}
