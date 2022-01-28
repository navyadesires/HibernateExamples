package com.mouritech.employeehibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Persistant class which is converted in to table 
 * in the database
 */
@Entity
public class Employee {
	
	@Id
	private Long empId;
	private String empFirstName;
	private String empLastName;
	private String empContactNo;
	private String empEmail;
    private String empAddress;
    
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Employee(String empFirstName, String empLastName, String empContactNo,String empEmail, String empAddress) {
		super();
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empContactNo = empContactNo;
		this.empEmail = empEmail;
		this.empAddress = empAddress;
	}



	public Employee(Long empId, String empFirstName, String empLastName, String empContactNo,String empEmail,
			String empAddress ) {
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empContactNo = empContactNo;
		this.empEmail = empEmail;
		this.empAddress = empAddress;
	}



	public Long empId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpContactNo() {
		return empContactNo;
	}

	public void setEmpContactNo(String empContactNo) {
		this.empContactNo = empContactNo;
	}
	public String getempEmail() {
		return empContactNo;
	}

	public void setempEmail(String empContactNo) {
		this.empContactNo = empContactNo;
	}
	
	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empContactNo=" + empContactNo + ",empEmail="+ empEmail+", empAddress=" + empAddress + "]";
	}
	
	

}
