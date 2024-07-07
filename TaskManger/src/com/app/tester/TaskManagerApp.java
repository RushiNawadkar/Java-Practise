package com.app.tester;

import static com.app.TaskManger.Task.count;
import static com.app.utils.utilityTask.addTask;
import static com.app.utils.utilityTask.deleteTask;
import static com.app.utils.utilityTask.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

import com.app.TaskManger.Status;
import com.app.TaskManger.Task;
import com.app.utils.utilityTask;

public class TaskManagerApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<Integer, Task> map = new TreeMap<>();
			boolean exit = false;
			while (!exit) {
				System.out.println("1. Add New Task  \r\n" + "2.show details \n" + "3. Delete a task  \r\n"
						+ "4. Update task status  \r\n" + "5. Display all pending tasks \r\n"
						+ "  6.write data into file" + "7.read data from file");

				System.out.println("choose option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("enter =>taskName,discription,taskdate,Status,active)");
						Task task = addTask(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextBoolean(), map);

						map.put(task.getTaskid(), task);
						System.out.println("Task Added sussfully" + task);
						break;
					case 2:
						map.forEach((k, v) -> System.out.println(v));
						break;
					case 3:
						System.out.println("delete task by id");
						deleteTask(sc.nextInt(), map);
						System.out.println("Task Deleted");
						break;
					case 4:
						System.out.println("enter id  and new update status");
						utilityTask.updatestatus(sc.nextInt(), sc.next(), map);
						break;
					case 5:

						for (int i = 1; i <= count; i++) {
							if (map.get(i).getStatus() == Status.valueOf("PENDING")) {
								System.out.println(map.get(i));
							}
						}
						break;
					case 6:
						System.out.println("Enter file name to add details");
						Stream<Task> stream = map.values().stream();
						System.out.println("enter filename, to store the details");
						storedetails(stream, sc.next());
						System.out.println("data stored succesfully");
						break;
					case 7:
						System.out.println("Enter the file to read");
						String res = readdetails(sc.next());
						System.out.println(res);
						break;
					}

				} catch (Exception e) {
					sc.nextLine();
					e.printStackTrace();
				}
			}
		}
	}

}
