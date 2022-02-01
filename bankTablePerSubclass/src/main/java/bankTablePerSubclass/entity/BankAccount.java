package bankTablePerSubclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "BankAccount_subclass")
@Inheritance(strategy = InheritanceType.JOINED)
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accNo")
	private int accNo;
	@Column(name = "accName")
	private String accName;
	@Column(name = "accBalance")
	private int accBalance;
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(String accName, int accBalance) {
		super();
		this.accName = accName;
		this.accBalance = accBalance;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public int getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(int accBalance) {
		this.accBalance = accBalance;
	}
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", accName=" + accName + ", accBalance=" + accBalance + "]";
	}
	
	

}