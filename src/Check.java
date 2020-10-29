
public class Check extends PaymentType{
public String check;
	
	public Check(String check) {
		super();
		this.check = check;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return "Check [check=" + check + "]";
	}
	
	
	
}
