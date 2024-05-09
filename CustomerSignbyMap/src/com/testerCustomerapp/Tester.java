package com.testerCustomerapp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.CustomerUtils.PopulatedMap;
import com.CustomerUtils.ValiadationRule;
import com.customer.Customer;
import com.customer.SortByDob;

public class Tester {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
//			Map<String, Customer> custmap = new HashMap<>();
			Map<String, Customer> custmap = PopulatedMap.populatedlist();
			boolean exit = false;
			while (!exit) {

				System.out.println("======Options====");
				System.out.println(
						"1.Enter the details \n2.Show Detail \n3.Sign in \n4.Remove Account \n5.Sort By Email");
				try {
					switch (in.nextInt()) {
					case 1:
						System.out.println("Ente the Details");
						System.out.println("Enter fname,lname,email,password,regamt,date,plan");
						Customer c = ValiadationRule.ValidateRule(in.next(), in.next(), in.next(), in.next(),
								in.nextDouble(), in.next(), in.next(), custmap);
						custmap.put(c.getemail(), c);
						System.out.println("Information Added Succesfully");
						break;
					case 2:
						System.out.println("Display All Details");
						
//						for (Customer cust : custmap.values()) {
//							System.out.println(cust);
//						}
						custmap.forEach((k,v) -> System.out.println(v));
						break;
					case 3:
						System.out.println("Sign in");
						System.out.println("Enter email password");
						c = ValiadationRule.Signin( in.next(),  in.next(),custmap);
						System.out.println("Sign-in successfully" + c);
						break;
					case 4:
						System.out.println("Delete Account Details");
						PopulatedMap.removeAccount(in.next(),in.next(), custmap);
						break;
					case 5:
						System.out.println("Sorting By Email");
//						TreeMap<Integer, BankAccount> sortedAcctMap = new TreeMap<>(accounts);
//						System.out.println("Sorted accts as per asc acct nos");
//						for (BankAccount a : sortedAcctMap.values())
//							System.out.println(a);
//						break;
						TreeMap<String, Customer> SortAccMap = new TreeMap<>(PopulatedMap.populatedlist());
//						for (Customer a : SortAccMap.values())
//							System.out.println(a);
						
						
						SortAccMap.forEach((k,v) -> System.out.println(v));
						break;
					case 6:
						LinkedList<Customer>list=new LinkedList<>(custmap.values());
						
						Collections.sort(list, new SortByDob());
						for(Customer i :list) {
							System.out.println(i);
						}
						
						break;

					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					in.nextLine();
				}
			}
		}
	}

}
