package com.mouritech.onetomanybidirectonalexample.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.onetomanybidirectonalexample.entity.Employee;
import com.mouritech.onetomanybidirectonalexample.util.HibernateUtil;



public class EmployeeDao {
	public void saveEmployee(Employee emp) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(emp);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public Employee getEmployee(Long empid) {
		Transaction transaction = null;
		Employee empById = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			empById = session.get(Employee.class, empid);
			if(empById!=null) {
				
				System.out.println("Employee details are = " + empById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return empById;
		
	}
}