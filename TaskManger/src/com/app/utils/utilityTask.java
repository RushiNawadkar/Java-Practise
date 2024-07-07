package com.app.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Stream;

import com.app.TaskManger.Status;
import com.app.TaskManger.Task;

public class utilityTask {

	public static Task addTask(String taskName, String discription, String taskdate, String status, boolean active,
			Map<Integer, Task> map) {

		return new Task(taskName, discription, LocalDate.parse(taskdate), Status.valueOf(status.toUpperCase()), active);

	}

	public static void deleteTask(int taskid, Map<Integer, Task> map) {
		if (map.containsKey(taskid)) {
			map.remove(taskid);
		}
	}

	public static void updatestatus(int taskid, String status, Map<Integer, Task> map) {
		Task task = map.get(taskid);
		System.out.println(task);
		if (task != null) {
			Status s = Status.valueOf(status.toUpperCase());
			task.setStatus(s);
			System.out.println("update task Succesful");
		} else {
			System.out.println("update task fialed!!!");
		}
	}

	// add method to write detail in file
	public static void storedetails(Stream<Task> stream, String filename) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
			stream.forEach(s -> pw.println(s));
		}
	}

	// add method to read details from file
	public static String readdetails(String filename) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			br.lines().forEach(line -> System.out.println(line));
		}
		return "-----file read successfully---";
	}

}
