package com.restfulwebservices.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Registration")
@IdClass(RegisterId.class)
public class Registration {
	@Id
	@Column(name = "courseID")
	private Long courseId;
	
	@Id
	@Column(name = "studentID")
	private Long studentId;
	
	private String semester;
	
	private String status;
	
	private Date registerDate;
	
	private Date targetDate;
	
	

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Registration(Long courseId, Long studentId, String semester, String status, Date registerDate,
			Date targetDate) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
		this.semester = semester;
		this.status = status;
		this.registerDate = registerDate;
		this.targetDate = targetDate;
	}



	public Long getCourseId() {
		return courseId;
	}



	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}



	public Long getStudentId() {
		return studentId;
	}



	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}



	public String getSemester() {
		return semester;
	}



	public void setSemeter(String semester) {
		this.semester = semester;
	}



	public String getStatus() {
		return status;
	}



	public void setStatues(String status) {
		this.status = status;
	}



	public Date getRegisterDate() {
		return registerDate;
	}



	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}



	public Date getTargetDate() {
		return targetDate;
	}



	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}



	@Override
	public String toString() {
		return "Registration [courseId=" + courseId + ", studentId=" + studentId + ", semeter=" + semester + ", status="
				+ status + ", registerDate=" + registerDate + ", targetDate=" + targetDate + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((registerDate == null) ? 0 : registerDate.hashCode());
		result = prime * result + ((semester == null) ? 0 : semester.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((targetDate == null) ? 0 : targetDate.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (registerDate == null) {
			if (other.registerDate != null)
				return false;
		} else if (!registerDate.equals(other.registerDate))
			return false;
		if (semester == null) {
			if (other.semester != null)
				return false;
		} else if (!semester.equals(other.semester))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (targetDate == null) {
			if (other.targetDate != null)
				return false;
		} else if (!targetDate.equals(other.targetDate))
			return false;
		return true;
	}


}
