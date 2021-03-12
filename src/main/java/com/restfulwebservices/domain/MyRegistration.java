package com.restfulwebservices.domain;

import java.util.Date;
import java.util.List;

public class MyRegistration {
	
	
	
	private String courseName;
	private Date registerDate;
	private Date targetDate;
	private String Status;
	
	
	public MyRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}




	public MyRegistration(String courseName, Date registerDate, Date targetDate, String status) {
		super();
		this.courseName = courseName;
		this.registerDate = registerDate;
		this.targetDate = targetDate;
		Status = status;
	}




	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public Date getTargetDate() {
		return targetDate;
	}


	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}
	
	


	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}


	@Override
	public String toString() {
		return "MyCourse [courseName=" + courseName + ", registerDate=" + registerDate + ", targetDate=" + targetDate
				+ ", Status=" + Status + "]";
	}


	
	

	
}