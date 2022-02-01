package bankTablePerSubclass.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "saving_account_subclass")
@PrimaryKeyJoinColumn(name = "accNo")
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