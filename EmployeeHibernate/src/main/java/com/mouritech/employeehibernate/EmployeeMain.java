package com.mouritech.employeehibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.employeehibernate.entity.Employee;
import com.mouritech.employeehibernate.util.Hibernate;

public class EmployeeMain {

	public static void main(String[] args) {

		Employee employee = new Employee(125L, "Ramya", "bharati", "980543534","navya@gmail.com", "7-8");
		Employee employee1 = new Employee(126L, "junnu", "chinnu", "8985435345","junnu@gmail.com" , "1-8");

		Transaction transaction = null;

		try (Session session = Hibernate.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();
			// save the student objects in to database
			session.save(employee);
			session.save(employee1);
			// commit transaction
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}

		// retrieve the data from database to java program using hibernate

		try (Session session = Hibernate.getSessionFactory().openSession()) {

			List<Employee> employeeList = session.createQuery("from Employee", Employee.class).list();
			employeeList.forEach(emp -> System.out.println(emp));

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

}
