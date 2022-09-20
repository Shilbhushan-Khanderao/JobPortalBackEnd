package com.JobPortal.pojo;

import javax.persistence.*;

@Entity
@Table(name = "Education")
public class Education{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "educationid")
	private int educationid;
	
	@Column(name = "educationtype")
	private String educationtype;
	
	@Column(name = "sscpercent")
	private float sscpercent;
	
	@Column(name = "hscpercent")
	private float hscpercent;
	
	@Column(name = "diplomapercent")
	private float diplomapercent;
	
	@Column(name = "degreepercent")
	private float degreepercent;

	@Column(name = "masterspercent")
	private float masterspercent;
	@Column(name = "sscyear")
	private String sscyear;
	
	@Column(name = "hscyear")
	private String hscyear;
	
	@Column(name = "diplomayear")
	private String diplomayear;
	
	@Column(name = "degreeyear")
	private String degreeyear;

	@Column(name = "mastersyear")
	private String mastersyear;
	
	public Education(){
		
	}
	
	public Education(String educationtype, float sscpercent, float hscpercent, float diplomapercent,
			float degreepercent, float masterspercent, String sscyear, String hscyear, String diplomayear,
			String degreeyear, String mastersyear) {
		this.educationtype = educationtype;
		this.sscpercent = sscpercent;
		this.hscpercent = hscpercent;
		this.diplomapercent = diplomapercent;
		this.degreepercent = degreepercent;
		this.masterspercent = masterspercent;
		this.sscyear = sscyear;
		this.hscyear = hscyear;
		this.diplomayear = diplomayear;
		this.degreeyear = degreeyear;
		this.mastersyear = mastersyear;
	}

	public int getEducationid() {
		return educationid;
	}

	public void setEducationid(int educationid) {
		this.educationid = educationid;
	}

	public String getEducationtype() {
		return educationtype;
	}

	public void setEducationtype(String educationtype) {
		this.educationtype = educationtype;
	}

	public float getSscpercent() {
		return sscpercent;
	}

	public void setSscpercent(float sscpercent) {
		this.sscpercent = sscpercent;
	}

	public float getHscpercent() {
		return hscpercent;
	}

	public void setHscpercent(float hscpercent) {
		this.hscpercent = hscpercent;
	}

	public float getDiplomapercent() {
		return diplomapercent;
	}

	public void setDiplomapercent(float diplomapercent) {
		this.diplomapercent = diplomapercent;
	}

	public float getDegreepercent() {
		return degreepercent;
	}

	public void setDegreepercent(float degreepercent) {
		this.degreepercent = degreepercent;
	}

	public float getMasterspercent() {
		return masterspercent;
	}

	public void setMasterspercent(float masterspercent) {
		this.masterspercent = masterspercent;
	}

	public String getSscyear() {
		return sscyear;
	}

	public void setSscyear(String sscyear) {
		this.sscyear = sscyear;
	}

	public String getHscyear() {
		return hscyear;
	}

	public void setHscyear(String hscyear) {
		this.hscyear = hscyear;
	}

	public String getDiplomayear() {
		return diplomayear;
	}

	public void setDiplomayear(String diplomayear) {
		this.diplomayear = diplomayear;
	}

	public String getDegreeyear() {
		return degreeyear;
	}

	public void setDegreeyear(String degreeyear) {
		this.degreeyear = degreeyear;
	}

	public String getMastersyear() {
		return mastersyear;
	}

	public void setMastersyear(String mastersyear) {
		this.mastersyear = mastersyear;
	}

}
