package com.JobPortal.pojo;

import javax.persistence.*;

@Entity
@Table(name = "Application")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "applicationid")
	private int applicationid;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "applicationstatus")
	private String applicationstatus;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Jobseeker.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "jobseekerid",referencedColumnName = "jobseekerid")
	private Jobseeker jobseeker;
	
	public Application() {
		
	}
	
	public Application(String date, String applicationstatus) {
		this.date = date;
		this.applicationstatus = applicationstatus;
	}

	public int getApplicationid() {
		return applicationid;
	}

	public void setApplicationid(int applicationid) {
		this.applicationid = applicationid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getApplicationstatus() {
		return applicationstatus;
	}

	public void setApplicationstatus(String applicationstatus) {
		this.applicationstatus = applicationstatus;
	}

	public Jobseeker getJobseeker() {
		return jobseeker;
	}
	
	public void setJobseeker(Jobseeker jobseeker) {
		this.jobseeker = jobseeker;
	}

	@Override
	public String toString() {
		return  applicationid +" : "+ date + " : "+ applicationstatus;
	}
	
	
}
