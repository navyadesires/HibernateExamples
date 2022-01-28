package com.mouritech.hibernate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

/*
 * Persistant class which is converted in to table 
 * in the database
 */
@Entity
public class Student {
	
	@Id
	private Long studId;
	private String studFirstName;
	private String studLastName;
	private String studContactNo;
	
	

	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Student(String studFirstName, String studLastName, String studContactNo) {
		super();
		this.studFirstName = studFirstName;
		this.studLastName = studLastName;
		this.studContactNo = studContactNo;
	}



	public Student(Long studId, String studFirstName, String studLastName, String studContactNo) {
		super();
		this.studId = studId;
		this.studFirstName = studFirstName;
		this.studLastName = studLastName;
		this.studContactNo = studContactNo;
	}



	public Long getStudId() {
		return studId;
	}

	public void setStudId(Long studId) {
		this.studId = studId;
	}

	public String getStudFirstName() {
		return studFirstName;
	}

	public void setStudFirstName(String studFirstName) {
		this.studFirstName = studFirstName;
	}

	public String getStudLastName() {
		return studLastName;
	}

	public void setStudLastName(String studLastName) {
		this.studLastName = studLastName;
	}

	public String getStudContactNo() {
		return studContactNo;
	}

	public void setStudContactNo(String studContactNo) {
		this.studContactNo = studContactNo;
	}

	@ManyToMany(mappedBy ="course" ,cascade = {CascadeType.ALL})
	private List<Course> courses;

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studFirstName=" + studFirstName + ", studLastName=" + studLastName
				+ ", studContactNo=" + studContactNo + "]";
	}
	
	

}