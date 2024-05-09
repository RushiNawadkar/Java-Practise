package com.customer;

import java.time.LocalDate;

public class Customer {
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private double regamt;
	private LocalDate dob;
	private ServicePlan plan;
	static int ctr=0;
	
	public Customer(String fname, String lname, String email, String password, double regamt, LocalDate dob,
			ServicePlan plan) {
		super();
		this.id = ++ctr;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.regamt = regamt;
		this.dob = dob;
		this.plan = plan;
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
	public String getLname() {
		return lname;
	}
	public String getemail() {
		return email;
	}
	public double getRegamt() {
		return regamt;
	}
	public LocalDate getDob() {
		return dob;
	}
	public ServicePlan getPlan() {
		return plan;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", regamt=" + regamt + ", dob=" + dob + ", plan=" + plan + "]";
	}
	
}
