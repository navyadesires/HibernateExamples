package com.mouritech.onetooneexample;

import com.mouritech.onetooneexample.dao.EmployeeDao;
import com.mouritech.onetooneexample.model.Employee;
import com.mouritech.onetooneexample.model.Employee_Details;

public class OneToOneExample {

	public static void main(String[] args) {
		Employee emp = new Employee("navya","sriii","navyasrii@gmail.com");
		Employee_Details empdetails = new Employee_Details("dancing","kabaddi");
		empdetails.setEmployee(emp);
		emp.setEmpDetails(empdetails);
		
		EmployeeDao empDao = new EmployeeDao();
		empDao.saveEmployee(emp);

	}

}