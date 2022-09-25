package com.JobPortal.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Jobseeker")
public class Jobseeker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobseekerid")
	private int jobseekerid;

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

	@Column(name = "emailid")
	private String emailid;

	@Column(name = "mobilenumber")
	private String mobilenumber;

	@Column(name = "dob")
	private String dob;

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "address")
	private String address;

	@OneToMany(mappedBy = "jobseeker",targetEntity = Application.class,cascade = CascadeType.ALL)
	private List<Application> applications;
	
	@OneToMany(mappedBy = "jobseeker",targetEntity = Education.class,cascade = CascadeType.ALL)
	private List<Education> educations;
	
	@OneToMany(mappedBy = "jobseeker",targetEntity = Experience.class,cascade = CascadeType.ALL)
	private List<Experience> experiences;
	
	public Jobseeker() {

	}
	
	public Jobseeker(String username, String password, String fname, String mname, String lname, String emailid,
			String mobilenumber, String dob, int age, String gender, String address) {
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.emailid = emailid;
		this.mobilenumber = mobilenumber;
		this.dob = dob;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public int getJobseekerid() {
		return jobseekerid;
	}
	
	public void setJobseekerid(int jobseekerid) {
		this.jobseekerid = jobseekerid;
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

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	
	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	@Override
	public String toString() {
		return +jobseekerid + " : " + username + " : " + password + " : " + fname + " : " + mname + " : " + lname
				+ " : " + emailid + " : " + mobilenumber + " : " + dob + " : " + age + " : " + gender + " : " + address;
	}

}
