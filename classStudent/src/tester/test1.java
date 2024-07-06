package tester;

import static utils.StudentCollectionUtils.populateMap;
import static utils.StudentCollectionUtils.populateList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.app.core.Student;

public class test1 {

	public static void main(String[] args) {
		System.out.println("Student From Map");
		// 1 Display All Student detail
		List<Student> list = populateList();
		list.forEach((Student) -> System.out.println(Student));
		// by Using Map
		Map<String, Student> map = populateMap(list);
		map.forEach((K, S) -> System.out.println(S.getRollNo() + "  " + S.getGpa()));

		// Display all Student detail sorted as per GPA
//		
//		Collections.sort(list, (s1, s2) -> {
//			if (s1.getGpa() < s2.getGpa())
//				return 1;
//			if (s1.getGpa() > s2.getGpa())
//				return -1;
//			return 0;
//
//		});
//		//display Sorted List
//		System.out.println("list");
//		list.forEach(s->System.out.println(s.getGpa()));

		// rewrite below Statement using functional literal
		Comparator<Student> StudentCom = (s1, s2) -> {
			if (s1.getGpa() < s2.getGpa())
				return 1;
			if (s1.getGpa() > s2.getGpa())
				return -1;
			return 0;
		};

		Collections.sort(list, StudentCom);
		list.forEach(s -> System.out.println(s.getGpa()));

		// cast double use comapreTo method
		Comparator<Student> StudentCom1 = (s1, s2) -> ((Double) s1.getGpa()).compareTo(s2.getGpa());// Asscending
		Collections.sort(list, StudentCom1);
		list.forEach(s -> System.out.println(s.getGpa()));

		// Remove all failed Student from map n diplay map again
//		System.out.println(map.values());
		map.values().removeIf(s -> s.getGpa() < 6);
		map.forEach((k,v)->System.out.println(v));
//		for (Map.Entry<String, Student> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}


