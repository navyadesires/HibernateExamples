package com.mouritech.crudwithhibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import  com.mouritech.crudwithhibernate.entity.Customer;
import  com.mouritech.crudwithhibernate.service.CustomerService;
import  com.mouritech.crudwithhibernate.util.HibernateUtil;


public class CustomerDao {
	
	public void customerSave(Customer cus) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the customer object in to database
			session.save(cus);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public void getAllCustomers() {
		// retrieve the data from database to java program using hibernate
		//Transaction transaction = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {

					List<Customer> customerList = session.createQuery("from Customer", Customer.class).list();
					customerList.forEach(cusid -> System.out.println(cusid));

				} catch (Exception e) {
					e.printStackTrace();
				}
				
		
	}

	public void deleteCustomer(Class<?> type,Serializable cusid) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			Customer cus = session1.get(Customer.class, cusid);
			if(cus!=null) {
				session1.remove(cus);
				System.out.println("Customer deleted successfully");
			}
			
			/*
			 * Customer cus2 = new Customer(); emp2.setEmpId(cusid); session1.delete(cus2);
			 * System.out.println("Customer deleted"); transaction1.commit();
			 */
			transaction1.commit();
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void updateCustomer(Long cusid,String mobNo) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the Customer object in to database
			//session.saveOrUpdate(cus);
			
			//get entity from database
			Customer updatingCus = session.get(Customer.class, cusid);
			System.out.println(updatingCus);
			//do changes
			updatingCus.setCusMobileNo(mobNo);
			//update the Customer object
			session.saveOrUpdate(updatingCus);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void getCustomerById(Long cusid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the Customer object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			Customer cusById = session.get(Customer.class, cusid);
			if(cusById!=null) {
				
				System.out.println("Customer details are = " + cusById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}


}