@SuppressWarnings("serial")
public class NotEnoughNumbersException  extends IllegalArgumentException {
	
	String nene;
	
	public NotEnoughNumbersException() {
		super();
		nene = "";
	}

	public NotEnoughNumbersException (String str) {
		super("Missing an Operand: " + str);
		nene = "Missing an Operand: " + str;
	}
	
	@Override
	public String getMessage() {
		return nene;
		
	}

}
