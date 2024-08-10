package com.db.database.entity;

public class Task {
	private int id;
	private String task;
	private int duration;
	private String priority;
	private String assigne;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getAssigne() {
		return assigne;
	}
	public void setAssigne(String assigne) {
		this.assigne = assigne;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", task=" + task + ", duration=" + duration + ", priority=" + priority + ", assigne="
				+ assigne + ", status=" + status + "]";
	}
	

}
