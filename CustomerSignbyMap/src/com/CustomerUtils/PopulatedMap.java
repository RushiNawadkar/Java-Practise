package com.CustomerUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.CustException.CustException;
import com.customer.Customer;
import com.customer.ServicePlan;

public class PopulatedMap {
	// Remove Account 
	public static void  removeAccount(String email,String Password,Map<String, Customer>custmap) throws CustException {
//		if(!custmap.containsKey(email)) {
//			throw new CustException(" Email not Exit");
//		}
//		Customer cust=custmap.get(email);
//		System.out.println(cust);
//		if(cust.getPassword().equals(Password))
//			custmap.remove(email);
//			System.out.println("Remove account Successfully");
		if(!custmap.containsKey(email)) {
			throw new CustException("Incorrect email");
		}
		Customer cust=custmap.get(email);
		if(cust.getPassword().equals(Password)) {
			custmap.remove(email);
		}
		
	}
	 
	public static Map<String,Customer>populatedlist() {
		Customer c1=new Customer("a", "h", "raju234@gmail.com", "raju@23",2000 ,LocalDate.parse("1999-01-05"),ServicePlan.GOLD);
		Customer c2=new Customer("e","n","kavi12@gmail.com","kavi@123", 5000, LocalDate.parse("1998-02-05" ),ServicePlan.DIAMOND);
		Customer c3=new Customer("s", "f", "kadu786@gmail.com" ,"kadu@456" ,10000,LocalDate.parse("1856-05-05"),ServicePlan.PLATINUM);
		Customer c4=new Customer("a", "b", "raj113@gamil.com", "raj@123", 2000 ,LocalDate.parse("2001-02-05"), ServicePlan.GOLD);
		Customer[] customer= {c1,c2,c3,c4};
		Map<String,Customer> Cust=new HashMap<>();
		for(Customer ct:customer)
		{
			System.out.println(Cust.put(ct.getemail(),ct));
			
		}
//		Cust.forEach((k,v)->System.out.println(v));
		
		
		return Cust;
	}
//	public static Map<String, Customer> populateMap(List<Customer> list) {
//		HashMap<String, Customer> hm = new HashMap<>();
//		list.forEach(s -> hm.put(s.getemail(), s));
//		return hm;
//
//	}
}
