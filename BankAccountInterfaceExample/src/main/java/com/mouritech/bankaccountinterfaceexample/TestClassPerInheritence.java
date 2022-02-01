package com.mouritech.bankaccountinterfaceexample;

	import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.bankaccountinterfaceexample.entity.SavingAccount;
import com.mouritech.bankaccountinterfaceexample.entity.BankAccount;
import com.mouritech.bankaccountinterfaceexample.entity.CurrentAccount;
import com.mouritech.bankaccountinterfaceexample.util.HibernateUtil;
public class TestClassPerInheritence {
	public static void main(String[] args) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();

			BankAccount bank = new BankAccount();
			bank.setAccountName("Ramya");
            bank.setBalence(645.4);
            bank.deposite();
            bank.withdraw();
			
            
			CurrentAccount caccount = new CurrentAccount();
			bank.setAccountName("sai");
			caccount.setBalence(645.4);
			caccount.setServiceCharge(10.4f);
			

			SavingAccount saccount = new SavingAccount();
			bank.setAccountName("uma");
			saccount.setBalence(545.4);
			saccount.setIntersetRate(34.4f);
			

			// save all the above employee objects in to database
			session.save(bank);
			session.save(caccount);
			session.save(saccount);
			// commit transaction
			transaction.commit();
		  } catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}
}