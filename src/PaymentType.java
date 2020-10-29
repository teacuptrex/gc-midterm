
public class PaymentType {

	public String cash;
	public String credit; 
	public String check;
	public double amtGiven;

	public String getCash() {
		return cash;
	}
	public void setCash(String cash) {
		this.cash = cash;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public double getAmtGiven() {
		return amtGiven;
	}
	public void setAmtGiven(double amtGiven) {
		this.amtGiven = amtGiven;
	}
	@Override
	public String toString() {
		return "PaymentType [cash=" + cash + ", credit=" + credit + ", check=" + check + ", amtGiven=" + amtGiven + "]";
	}
	public PaymentType() {
		super();
	}
	
	
	
	
}
	
	

