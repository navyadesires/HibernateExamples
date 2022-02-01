package com.mouritech.bankaccountperclassexample.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SavingAccount")
@AttributeOverrides({
	@AttributeOverride(name = "accNo" ,column = @Column(name= "savingaccNo")),
	@AttributeOverride(name = "accName" ,column = @Column(name= "savingaccName")),
})

public class SavingAccount extends BankAccount{
	@Column(name = "service_charge")
	private int serviceCharge;

	public SavingAccount() {
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(int serviceCharge) {
		super();
		this.serviceCharge = serviceCharge;
	}

	public int getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(int serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	@Override
	public String toString() {
		return "SavingAccount [serviceCharge=" + serviceCharge + "]";
	}
	

}