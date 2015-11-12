/**
 * @author Nika Tsankashvili
 */
@SuppressWarnings("serial")
public class IllegalOperationException  extends IllegalArgumentException {
	
	String ioe;
	
	public IllegalOperationException() {
		super();
		ioe = "";
	}

	public IllegalOperationException (String str) {
		super("Invalid Operator: " + str);
		ioe = "Invalid Operator: " + str;
	}
	
	@Override
	public String getMessage() {
		return ioe;
		
	}

}
