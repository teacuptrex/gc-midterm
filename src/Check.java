

public class Check extends PaymentType {

	private String check;

	// Checkconstructor
	public Check(String check, double amtGiven) {
		super(amtGiven);
		this.check = check;
	}
	public Check() {
		
	}

	// check getter
	public String getCheck() {
		return check;
	}

	// check setter
	public void setCheck(String check) {
		this.check = check;
	}

	// check toString
	@Override
	public String toString() {
		return "Check [check=" + check + "]";
	}


}
