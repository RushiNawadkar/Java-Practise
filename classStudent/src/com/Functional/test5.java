package com.Functional;
import static utils.StudentCollectionUtils.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

import utils.StudentCollectionUtils;
public class test5 {

	public static void main(String[] args) {
		try(Scanner in=new Scanner(System.in)){
		// TODO Auto-generated method stub
		// get populated map of the student, diplay all
		// display tstudent detail from a specified subject
		Map<String, Student>Stduentmap=StudentCollectionUtils.populateMap(populateList());//conversion  list to map 
				// for Each 
		Stduentmap.forEach((k,v)->System.out.println(v));
		
//		Sorting Method
		System.out.println("Enter Subject name ");
		Subject chosenSub=Subject.valueOf(in.next().toUpperCase());
	    Stduentmap.values()   // Collection<Student>
	    .stream()//Stream<Student>:All
	    .filter(s->s.getSubject()==chosenSub)
	    .filter(s->s.getGpa()>6)
	    .forEach(s->System.out.println(s));
	    System.out.println();

	    
	    
//       Diplay sum of gps of all passed student
	    System.out.println("Sum of gpa of all student");
	    Map<String, Student>Studmap=StudentCollectionUtils.populateMap(populateList());
	    
	    double sum=Studmap.values().
	    stream()
	    .filter(s->s.getGpa()>5)
	    .mapToDouble(s->s.getGpa())
	    .sum();
	    System.out.print("result :"+ sum +" ");
	    
	    
//		sorted Student detiala from list of Students
	    //sorted as per the dob using function literal
	    //Stream --> sorted --> for each
	    List<Student>list = populateList();
	    Comparator<Student>comp=(s1,s2)->s1.getDob().compareTo(s2.getDob());
	    list.stream()
	    .sorted(comp)
	    .forEach(s->System.out.println(s));
	    System.out.println();
	    
	    
	    
	    
// 		sorting Student  print the name of the subject topper
        // map--collection--stream--filter(Subject)--max(Comaprator
	    //--get    
	    Student topper=Studmap.values()
	    .stream()
	    .filter(s->s.getSubject()==Subject.DBT)
	    .max((s1,s2)->((Double)s1.getGpa()).compareTo(s2.getGpa()))
	    .get();
	    System.out.println("Topper :"+topper);
	    
	    
//	    Optional<Student>optional=Studmap.values()
//	    		.stream()
//	    	    .filter(s->s.getSubject()==Subject.ANGULAR)
//	    	    .max((s1,s2)->((Double)s1.getGpa()).compareTo(s2.getGpa()));
//	    if(optional.isPresent())
//	    	System.out.println(optional.get());
//	    if(optional.isEmpty())
//	    	System.out.println(optional.get());
		
	}
	}
}
