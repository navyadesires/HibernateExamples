package com.mouritech.bankaccountinterfaceexample.entity;

	import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Saving_Account")
public class SavingAccount extends BankAccount {
	@Column(name = "bank_intersetRate")
	private float intersetRate;
	
		public SavingAccount() {
		super();
		this.intersetRate = intersetRate;
	}
	

	public float getIntersetRate() {
		return intersetRate;
	}

	public void setIntersetRate(float intersetRate) {
		this.intersetRate = intersetRate;
	}
	

	
	

}