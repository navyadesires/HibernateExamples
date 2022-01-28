package com.mouritech.crudwithhibernate.service;


import java.util.Scanner;

import com.mouritech.crudwithhibernate.dao.CustomerDao;
import com.mouritech.crudwithhibernate.entity.Customer;

public class CustomerService {
	
	static Scanner sc = new Scanner(System.in);
	CustomerDao cusdao = new CustomerDao();
	
	public void customerSave() {
		Customer cus = new Customer();
		System.out.println("Enter the details of the customer");
		//sc.nextLine()
		System.out.println("Enter the customer name....");
		cus.setCusName(sc.nextLine());
		System.out.println("Enter the customer email....");
		cus.setCusEmail(sc.nextLine());
		System.out.println("Enter the customer Age...");
		cus.setCusAge(sc.nextLong());
		System.out.println(sc.nextLine());
		
		System.out.println("Enter the customer mobile number....");
		cus.setCusMobileNo(sc.nextLine());
		cusdao.customerSave(cus);	
	}

	public void getAllCustomers() {
		
		cusdao.getAllCustomers();
	}
	
	public void deleteCustomer() {

		System.out.println("Enter the customer id to delete....");
		Long cusid = sc.nextLong();
		cusdao.deleteCustomer(Customer.class,new Long(cusid));
	}

	public void updateCustomer() {
		Customer cus = new Customer();
		System.out.println("Enter the details of the Customer");
		//sc.nextLine()
		System.out.println("Enter the Customer name....");
		cus.setCusName(sc.nextLine());
		System.out.println("Enter the Customer email....");
		cus.setCusEmail(sc.nextLine());
		System.out.println("Enter the Customer mobile number....");
		cus.setCusMobileNo(sc.nextLine());
		//cusdao.CustomerSave(cus);	
		//cusdao.updateCustomer(cus);
	}
	
	public  void getDetailsToUpdate() {
		System.out.println("Enter the customer id....");
		Long cusid = sc.nextLong();
		System.out.println("Enter the mobile no");
		String mobNo = sc.next();
		//return mobNo;
		cusdao.updateCustomer(cusid,mobNo);
	}

	public void getCustomerById() {
		System.out.println("Enter the customer id....");
		Long cusid = sc.nextLong();
		cusdao.getCustomerById(cusid);
	}


}