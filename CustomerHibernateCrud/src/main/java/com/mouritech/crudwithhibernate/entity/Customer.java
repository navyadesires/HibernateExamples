package com.mouritech.crudwithhibernate.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name = "customer_info")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerid")
	private Long cusId;
	@Column(name = "customerage")
	private Long cusAge;
	
	@Column(name = "customername")
	@Size(min=3)
	private String cusName;
	
	@Column(name = "customeremail")
	@Email
	private String cusEmail;
	
	@Column(name = "customermobno")
	@Pattern(regexp = "[0-9]", message="mobile number contains only digits")
	private String cusMobileNo;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	

	public Customer(Long cusAge, @Size(min = 3) String cusName, @Email String cusEmail,
			@Pattern(regexp = "[0-9]", message = "mobile number contains only digits") String empMobileNo, @Pattern(regexp = "[0-9]", message = "mobile number contains only digits") String cusMobileNo) {
		super();
		this.cusAge = cusAge;
		this.cusName = cusName;
		this.cusEmail = cusEmail;
		this.cusMobileNo = cusMobileNo;
	}






	public Customer(Long cusId, Long cusAge, @Size(min = 3) String cusName, @Email String cusEmail,
			@Pattern(regexp = "[0-9]", message = "mobile number contains only digits") String cusMobileNo) {
		super();
		this.cusId = cusId;
		this.cusAge = cusAge;
		this.cusName = cusName;
		this.cusEmail = cusEmail;
		this.cusMobileNo = cusMobileNo;
	}



	public Long getCusId() {
		return cusId;
	}



	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}



	public Long getCusAge() {
		return cusAge;
	}



	public void setCusAge(Long cusAge) {
		this.cusAge = cusAge;
	}



	public String getCusName() {
		return cusName;
	}



	public void setCusName(String cusName) {
		this.cusName = cusName;
	}



	public String getCusEmail() {
		return cusEmail;
	}



	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}



	public String getCusMobileNo() {
		return cusMobileNo;
	}



	public void setCusMobileNo(String cusMobileNo) {
		this.cusMobileNo = cusMobileNo;
	}



	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cusAge=" + cusAge + ", cusName=" + cusName + ", cusEmail=" + cusEmail
				+ ", cusMobileNo=" + cusMobileNo + "]";
	}


	
}