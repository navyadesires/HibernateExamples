package com.mouritech.bankaccountperclassexample.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CurrentAccount")
@AttributeOverrides({
	@AttributeOverride(name = "accNo" ,column = @Column(name= "currentaccNo")),
	@AttributeOverride(name = "accName" ,column = @Column(name= "currentaccName")),
})

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