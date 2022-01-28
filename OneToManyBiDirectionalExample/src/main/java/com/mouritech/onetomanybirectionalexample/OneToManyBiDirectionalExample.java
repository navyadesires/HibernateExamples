package com.mouritech.onetomanybirectionalexample;

import java.time.LocalDate;
import java.util.List;

import com.mouritech.onetomanybidirectonalexample.dao.DepartmentDao;
import com.mouritech.onetomanybidirectonalexample.dao.EmployeeDao;
import com.mouritech.onetomanybidirectonalexample.entity.Department;
import com.mouritech.onetomanybidirectonalexample.entity.Employee;

public class OneToManyBiDirectionalExample {

	public static void main(String[] args) {
		
		EmployeeDao empDao = new EmployeeDao();
		DepartmentDao deptDao = new DepartmentDao();
		
		Employee emp = new Employee("navya", "T", "navyaramya@gmail.com", 
													LocalDate.of(1998, 03, 20));
		empDao.saveEmployee(emp);
		
		//create some departments
		Department dept = new Department("GCP");
		dept.setEmployee(emp);
		deptDao.saveDepartment(dept);
		
		Department dept1 = new Department("SAP");
		dept1.setEmployee(emp);
		deptDao.saveDepartment(dept1);
		//empDao.saveEmployee(emp);
		
		System.out.println("Employee By ID  =" +empDao.getEmployee(1L));
		/*
		 * System.out.println("Department For ID  =" ); List<Department> deptList =
		 * empDao.getEmployee(1L).getDepartments(); System.out.println(deptList);
		 */
	}

}