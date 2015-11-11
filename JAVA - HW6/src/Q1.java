import java.util.Scanner;
/**
 * 
 * @author Nika Tsankashvili
 *
 */
public class Q1 {
	//Scanner
	private static Scanner myScanner;
	//Operand Variables
	private static double operand1, operand2;
	//Operator Variable
	private static char operator;
	//
	private static String inputLine;
	private static String[] inputLineToArray;

	public Q1() {
		setArguments();
	}

	public void setArguments() {

		boolean continueInput = true;

		do {
			try {

				myScanner = new Scanner(System.in);
				inputLine = myScanner.nextLine();
				inputLineToArray = inputLine.split(" ");

				//Check for not enough arguments
				if (inputLineToArray.length != 3) {
					throw new NotEnoughNumbersException(inputLine);
				}

				//Set Operands
				if (isNumeric(inputLineToArray[0])) {
					operand1 = Double.parseDouble(inputLineToArray[0]);
				} else {
					throw new NotANumberException(inputLineToArray[0]);
				}

				if (isNumeric(inputLineToArray[2])) {
					operand2 = Double.parseDouble(inputLineToArray[2]);
				} else {
					throw new NotANumberException(inputLineToArray[2]);
				}

				//Set Operator
				if (inputLineToArray[1].length() == 1 && checkOperator(inputLineToArray[1])) {
					operator = inputLineToArray[1].charAt(0);
				} else {
					throw new IllegalOperationException(inputLineToArray[1]);
				}
				//Check for zeros
				if (operand1 == 0 || operand2 == 0) {
					throw new ArithmeticException("Divisor cannot be zero");
				}
				//If everything is fine then no need to repeat.
				continueInput = false;
				System.out.println(calcReq(operand1, operator, operand2));

			} catch (NotANumberException | IllegalOperationException | 
					NotEnoughNumbersException | ArithmeticException ce){
				System.out.println(ce.getMessage());
			} 
		} while (continueInput);

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Q1();

	}

	public static double calcReq(double opnd1, char optr,double opnd2)
			throws ArithmeticException {

		double dblResult = 0;

		if (optr == '+') {
			//Do Addition
			dblResult = opnd1 + opnd2;
		} else if (optr == '-') {
			//Subtraction
			dblResult = opnd1 - opnd2;
		} else if (optr == '/'){
			//
			dblResult = opnd1 / opnd2;
		} else if (optr == '*') {
			//
			dblResult = opnd1 * opnd2;
		} else if (optr == '%') {
			//
			dblResult = opnd1 % opnd2;
		}

		return dblResult;
	}
	public static boolean checkOperator(String optr) {		
		if (optr.equals("+")) {
			//Do Addition
			return true;
		} else if (optr.equals("-")) {
			//Subtraction
			return true;
		} else if (optr.equals("/")){
			//
			return true;
		} else if (optr.equals("*")) {
			//
			return true;
		} else if (optr.equals("%")) {
			//
			return true;
		} else {
			//
			return false;
		}
	}

	/* Citation
	 * http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-a-numeric-type-in-java
	 */
	public static boolean isNumeric(String str)  
	{  
		try {  
			@SuppressWarnings("unused")
			double d = Double.parseDouble(str);  
		} catch(NumberFormatException nfe) {  
			return false;  
		}  
		return true;  
	}
}
