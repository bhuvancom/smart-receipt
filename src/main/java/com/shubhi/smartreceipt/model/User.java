package com.shubhi.smartreceipt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "fax")
	private String fax;

	@Temporal(TemporalType.DATE)
	@Column(name = "time_added")
	private Date time_added;

	public User(String name, String email, String fax, Date time_added) {
		this.name = name;
		this.email = email;
		this.fax = fax;
		this.time_added = time_added;
	}

	public User() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Date getTime_added() {
		return time_added;
	}

	public void setTime_added(Date time_added) {
		this.time_added = time_added;
	}

	@Override
	public String toString() {
		return "User{" + "userId=" + userId + ", name='" + name + '\'' + ", email='" + email + '\'' + ", fax='" + fax
				+ '\'' + ", time_added=" + time_added + '}';
	}
}
