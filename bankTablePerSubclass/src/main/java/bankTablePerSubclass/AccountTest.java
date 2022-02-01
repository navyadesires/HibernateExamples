package bankTablePerSubclass;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bankTablePerSubclass.entity.BankAccount;
import bankTablePerSubclass.entity.CurrentAccount;
import bankTablePerSubclass.entity.SavingAccount;
import bankTablePerSubclass.util.HibernateUtil;



public class AccountTest {

	public static void main(String[] args) {
	
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			BankAccount bankAccount = new BankAccount();
			bankAccount.setAccName("Ramya");
			bankAccount.setAccBalance(8900);
			
			
			SavingAccount savingAccount =new SavingAccount();
			savingAccount.setAccName("Navya");
			savingAccount.setAccBalance(7890);
			savingAccount.setServiceCharge(8);
			
			CurrentAccount currentAccount = new CurrentAccount();
			currentAccount.setAccName("Rakesh");
			currentAccount.setAccBalance(456);
			currentAccount.setInterestRate(30);
			
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