package com.CustomerUtils;

import java.time.LocalDate;
import java.util.Map;

import com.CustException.CustException;
import com.customer.Customer;
import com.customer.ServicePlan;

public class ValiadationRule {
	public static Customer ValidateRule(String fname, String lname, String email, String password, double regamt,
			String dob, String plan, Map<String, Customer> Custmap) throws CustException {
		duplicatemail(email, Custmap);
		LocalDate date = LocalDate.parse(dob);
		ServicePlan sp = validatePlan(plan, regamt);
		checkpassword(password,Custmap);
		return new Customer(fname, lname, email, password, regamt, date, sp);

	}
// check duplicate Account
	public static void duplicatemail(String email, Map<String, Customer> custmap) throws CustException {
		if(custmap.containsKey(email)) {
			throw new CustException("Invalid Email");
		}
		//Customer c = custmap.get(email);
//		System.out.println(c);
//		if(c.getemail().equals(email)){
//			throw new CustException("Email Already Exit");
			
	}

	// sign in account
	public static Customer Signin(String email, String Password, Map<String, Customer> Custmap) throws CustException {
		
		if(!Custmap.containsKey(email)) {
			throw new CustException("Incorrect email");
		}
		Customer cust=Custmap.get(email);
		if(!cust.getPassword().equals(Password)) {
			throw new CustException("Password incorrect ");
		}
		return cust;
		
		
	}
	
	
// check password
	public static void checkpassword(String Password, Map<String, Customer> Custmap) throws CustException {
		String regex = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
		if (!Password.matches(regex)) {
			throw new CustException("invalid Password");
		}

	}
// check amount and plan are choose correctly
	public static ServicePlan validatePlan(String Plan, double regamt) throws CustException {
		ServicePlan sp = ServicePlan.valueOf(Plan.toUpperCase());
		if (sp.getPlancost() == regamt) {
			return sp;
		}
		throw new CustException("Invalid Plan!!!!");

	}

}
