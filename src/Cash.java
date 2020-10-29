
public class Cash extends PaymentType{
	public String cash; 
	
	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}

	public Cash() {
	}

	@Override
	public String toString() {
		return "Cash [cash=" + cash + "]";
	}
	
	
	
}
