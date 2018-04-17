package com.pkrm.rest;

public class SubTask {
	public String subTaskTitle;
	 public String subTaskDescription;
	 public String subTaskAssignee;
	 public int s_Assignee_age;
	 public int estimatedHours;
	 
 public String getSubTaskTitle() {
		return subTaskTitle;
	}
	public void setSubTaskTitle(String subTaskTitle) {
		this.subTaskTitle = subTaskTitle;
	}
	public String getSubTaskDescription() {
		return subTaskDescription;
	}
	public void setSubTaskDescription(String subTaskDescription) {
		this.subTaskDescription = subTaskDescription;
	}
	public String getSubTaskAssignee() {
		return subTaskAssignee;
	}
	public void setSubTaskAssignee(String subTaskAssignee) {
		this.subTaskAssignee = subTaskAssignee;
	}
	public int getS_Assignee_age() {
		return s_Assignee_age;
	}
	public void setS_Assignee_age(int s_Assignee_age) {
		this.s_Assignee_age = s_Assignee_age;
	}
	public int getEstimatedHours() {
		return estimatedHours;
	}
	public void setEstimatedHours(int estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

}
