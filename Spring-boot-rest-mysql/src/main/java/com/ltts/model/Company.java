package com.ltts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="companies")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="cmp_name")
	private String cmpName;
	@Column(name="cmp_address")
	private String cmpAddress;
	@Column(name="email_id")
	private String emailId;
	
	
	public Company() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCmpName() {
		return cmpName;
	}


	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}


	public String getCmpAddress() {
		return cmpAddress;
	}


	public void setCmpAddress(String cmpAddress) {
		this.cmpAddress = cmpAddress;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Company(String firstName, String lastName, String emailId) {
		super();
		this.cmpName = cmpName;
		this.cmpAddress = cmpAddress;
		this.emailId = emailId;
	}


	@Override
	public String toString() {
		return "Company [id=" + id + ", cmpName=" + cmpName + ", cmpAddress=" + cmpAddress + ", emailId=" + emailId
				+ "]";
	}
}