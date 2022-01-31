package com.mouritech.criteriaqueryexample;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.mouritech.criteriaqueryexample.model.Product;


public class CriteriaQueryExample {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//employeeSave();
		betweenCriteria();
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sFactory = cfg.buildSessionFactory();
		Session session = sFactory.openSession();
		

		Criteria crit = session.createCriteria(Product.class);
		Criterion cn = Restrictions.ge("productPrice", new Float(25));

		//select * from product where productprice > 25000
		crit.add(cn);
		List productList = crit.list();
		System.out.println("List of total size......"+productList.size());
		Iterator<Product> itr = productList.iterator();
		
		while(itr.hasNext()) {
			Product p = itr.next();
			System.out.println("Product Id = " + p.getProductId());
			System.out.println("Product Id = " + p.getProductName());
			System.out.println("Product Id = " + p.getProductPrice());
			System.out.println("+++++++++++++++++++++++++++++++++++++");
		}
		
		sFactory.close();
		session.close();
		
		

	}
	public static void employeeSave() {
		Transaction transaction = null;
		Product p = new Product(123L, "ball Pen", 77);
		Product p1 = new Product(124L, "Reynolds Pen", 40);
		Product p2 = new Product(125L, "Pilot Pen", 79);
		Product p3 = new Product(126L, "Pencil ", 10);
		Product p4 = new Product(127L, "hero Pen", 54);
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sFactory = cfg.buildSessionFactory();
		Session session = sFactory.openSession();
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(p);
			session.save(p2);
			session.save(p1);
			session.save(p3);
			session.save(p4);
			// commit transaction
			transaction.commit();
		
	}
	
	@SuppressWarnings("deprecation")
	public static void betweenCriteria() {
		//employeeSave();
				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
				SessionFactory sFactory = cfg.buildSessionFactory();
				Session session = sFactory.openSession();
				Criteria crit = session.createCriteria(Product.class);
				Criterion cn = Restrictions.not(Restrictions.between("productPrice", new Float(25), new Float(45)));
				//select * from product where productprice between 25 and 45
				crit.add(cn);
				List productList = crit.list();
				System.out.println("List of total size......"+productList.size());
				Iterator<Product> itr = productList.iterator();
				
				while(itr.hasNext()) {
					Product p = itr.next();
					System.out.println("Product Id = " + p.getProductId());
					System.out.println("Product Id = " + p.getProductName());
					System.out.println("Product Id = " + p.getProductPrice());
					System.out.println("+++++++++++++++++++++++++++++++++++++");
				}
				
				sFactory.close();
				session.close();
	}
}