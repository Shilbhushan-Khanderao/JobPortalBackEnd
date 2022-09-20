package com.JobPortal.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JobProvider")
public class JobProvider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobproviderid")
	private int jobproviderid;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "fname")
	private String fname;
	
	@Column(name = "mname")
	private String mname;

	@Column(name = "lname")
	private String lname;

	@Column(name = "companyname")
	private String companyname;

	@Column(name = "mobileno")
	private String mobileno;

	@Column(name = "emailid")
	private String emailid;

	public JobProvider() {

	}
	
	public JobProvider(String username, String password, String fname, String mname, String lname, String companyname,
			String mobileno, String emailid) {
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.companyname = companyname;
		this.mobileno = mobileno;
		this.emailid = emailid;
	}

	public int getJobproviderid() {
		return jobproviderid;
	}

	public void setJobproviderid(int jobproviderid) {
		this.jobproviderid = jobproviderid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Override
	public String toString() {
		return username + " : " + password + " : " + fname + " : " +
				mname + " : " + lname + " : " + companyname + " : " +
				mobileno + " : " + emailid;
		
	}
}
