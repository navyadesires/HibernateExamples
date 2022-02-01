package com.mouritech.bankaccountperclassexample;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.bankaccountperclassexample.entity.SavingAccount;
import com.mouritech.bankaccountperclassexample.entity.BankAccount;
import com.mouritech.bankaccountperclassexample.entity.CurrentAccount;
import com.mouritech.bankaccountperclassexample.util.HibernateUtil;

public class TestClassPerInheritance {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			BankAccount bankAccount = new BankAccount();
			bankAccount.setAccName("Ramya");
			bankAccount.setAccBalance(6700);
			
			
			SavingAccount savingAccount =new SavingAccount();
			savingAccount.setAccName("sanket");
			savingAccount.setAccBalance(7800);
			savingAccount.setServiceCharge(4);
			
			CurrentAccount currentAccount = new CurrentAccount();
			currentAccount.setAccName("susmitha");
			currentAccount.setAccBalance(5689);
			currentAccount.setInterestRate(50);
			
			session.save(bankAccount);
			session.save(savingAccount);
			session.save(currentAccount);
			
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

}