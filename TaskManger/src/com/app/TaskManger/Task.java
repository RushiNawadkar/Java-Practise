package com.app.TaskManger;

import java.time.LocalDate;

public class Task {
	private int taskid;
	private String taskName;
	private String Discription;
	private LocalDate taskdate;
	private Status status;
	private boolean Active=false;
	public static int count=0;
	
	
	public Task(String taskName, String discription, LocalDate taskdate, Status status, boolean active) {
		count++;
		this.taskid =count;
		this.taskName = taskName;
		Discription = discription;
		this.taskdate = taskdate;
		this.status = status;
		Active = active;
	}


	public int getTaskid() {
		return taskid;
	}


	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public String getDiscription() {
		return Discription;
	}


	public void setDiscription(String discription) {
		Discription = discription;
	}


	public LocalDate getTaskdate() {
		return taskdate;
	}


	public void setTaskdate(LocalDate taskdate) {
		this.taskdate = taskdate;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public boolean isActive() {
		return Active;
	}


	public void setActive(boolean active) {
		Active = active;
	}


	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", taskName=" + taskName + ", Discription=" + Discription + ", taskdate="
				+ taskdate + ", status=" + status + ", Active=" + Active + "]";
	}
	
	
}
