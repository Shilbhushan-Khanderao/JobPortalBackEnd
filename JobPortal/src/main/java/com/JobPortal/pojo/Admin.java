package com.JobPortal.pojo;

import javax.persistence.*;

@Entity
@Table(name = "Admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adminid")
	private int adminid;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	
	public Admin() {
		
	}
	
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
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
	
	@Override
	public String toString() {
		return adminid + " : "+ username + " : " + password;
	
	}
}