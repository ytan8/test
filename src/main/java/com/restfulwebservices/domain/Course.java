package com.restfulwebservices.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {
	
	@Id
	@GeneratedValue
	private Long courseID;
	
	private String name;
	private String description;
	private String availableSemster;
	private String credit;
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(Long courseID, String name, String description, String availableSemster, String credit) {
		super();
		this.courseID = courseID;
		this.name = name;
		this.description = description;
		this.availableSemster = availableSemster;
		this.credit = credit;
	}
	
	
	public Long getCourseID() {
		return courseID;
	}
	public void setCourseID(Long courseID) {
		this.courseID = courseID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvailableSemster() {
		return availableSemster;
	}
	public void setAvailableSemster(String availableSemster) {
		this.availableSemster = availableSemster;
	}
	
	
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableSemster == null) ? 0 : availableSemster.hashCode());
		result = prime * result + ((courseID == null) ? 0 : courseID.hashCode());
		result = prime * result + ((credit == null) ? 0 : credit.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Course other = (Course) obj;
		if (availableSemster == null) {
			if (other.availableSemster != null)
				return false;
		} else if (!availableSemster.equals(other.availableSemster))
			return false;
		if (courseID == null) {
			if (other.courseID != null)
				return false;
		} else if (!courseID.equals(other.courseID))
			return false;
		if (credit == null) {
			if (other.credit != null)
				return false;
		} else if (!credit.equals(other.credit))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", name=" + name + ", description=" + description
				+ ", availableSemster=" + availableSemster + ", credit=" + credit + "]";
	}
	
	
	

}
