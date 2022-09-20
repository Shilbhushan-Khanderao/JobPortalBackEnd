package com.JobPortal.pojo;


import javax.persistence.*;

@Entity
@Table(name = "Experience")
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expid")
	private int expid;
	
	@Column(name = "companyname")
	private String companyname;
	
	@Column(name = "companysector")
	private String companysector;
	
	@Column(name = "jobtitle")
	private String jobtitle;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "duration")
	private int duration;
	
	public Experience(){
		
	}

	public int getExpid() {
		return expid;
	}

	public void setExpid(int expId) {
		expid = expId;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyName) {
		companyname = companyName;
	}

	public String getCompanysector() {
		return companysector;
	}

	public void setCompanysector(String companySector) {
		companysector = companySector;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobTitle) {
		jobtitle = jobTitle;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
