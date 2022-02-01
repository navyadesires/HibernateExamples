package com.mouritech.bankaccountperclassexample.util;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.mouritech.bankaccountperclassexample.entity.BankAccount;
import com.mouritech.bankaccountperclassexample.entity.CurrentAccount;
import com.mouritech.bankaccountperclassexample.entity.SavingAccount;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration cfg = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
				settings.put(Environment.URL,"jdbc:mysql://localhost:3306/mouritech_restwithhib");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS,"rootpass");
				settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create");
				
				cfg.setProperties(settings);
				cfg.addAnnotatedClass(BankAccount.class);
				cfg.addAnnotatedClass(SavingAccount.class);
				cfg.addAnnotatedClass(CurrentAccount.class);
			
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
													.applySettings(cfg.getProperties()).build();
				System.out.println("Hibernate Java Configuration Service Registry Created....");
				sessionFactory = cfg.buildSessionFactory(serviceRegistry);
				return sessionFactory;
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	public static void shutdown() {
		if(serviceRegistry != null) {
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
}
}