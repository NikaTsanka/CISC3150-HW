public class NotANumberException extends IllegalArgumentException {
	
	String nane;
	
	public NotANumberException() {
		super();
		nane = "";
	}
	
	public NotANumberException(String str) {
		super("Invalid Operand: " + str);
		nane = "Invalid Operand: " + str;
	}
	
	@Override
	public String getMessage() {
		return nane;
		
	}

}
