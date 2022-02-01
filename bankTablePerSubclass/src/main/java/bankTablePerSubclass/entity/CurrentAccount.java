package bankTablePerSubclass.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "current_account_subclass")
@PrimaryKeyJoinColumn(name = "accNo")

public class CurrentAccount extends BankAccount {
	@Column(name = "interest_rate")
	private int interestRate;

	public CurrentAccount(int interestRate) {
		super();
		this.interestRate = interestRate;
	}

	public CurrentAccount() {
	
		// TODO Auto-generated constructor stub
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "CurrentAccount [interestRate=" + interestRate + "]";
	}
	
}