package com.mouritech.onetoonestockexample.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mouritech.onetoonestockexample.model.Stock;
import com.mouritech.onetoonestockexample.util.HibernateUtil;
public class StockDao {
	
	public void saveStock(Stock stk) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(stk);
			// commit transaction
			//transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public Stock getStock(Long stockid) {
		Transaction transaction = null;
		Stock stkById = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			stkById = session.get(Stock.class, stockid);
			if(stkById!=null) {
				
				System.out.println("Stock details are = " + stkById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return stkById;
		
	}

}
