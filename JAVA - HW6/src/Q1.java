import java.util.Scanner;
/**
 * 
 * @author Nika Tsankashvili
 *
 */
public class Q1 {
	//Scanner Variable
	private static Scanner myScanner;
	//Operand Variables
	private static double operand1, operand2;
	//Operator Variable
	private static char operator;
	//String Variables
	private static String inputLine;
	//private static String[] passedLineToArray;
	
	//Main
	public static void main(String[] args) {
		
		//Class Object
		Q1 workingObj = new Q1();
		
		//Pass it to the set argument method.
		workingObj.setArguments(args);

	}
	
	public void setArguments(String[] stringArray) {

		boolean continueInput = true;
		boolean repeat = false;

		do {
			try {
				if (repeat) {
					//Open scanner and get the input from the user
					myScanner = new Scanner(System.in);
					inputLine = myScanner.nextLine();
					stringArray = inputLine.split(" ");
				}
				

				//Check for not enough arguments
				if (stringArray.length != 3) {
					repeat = true;
					throw new NotEnoughNumbersException(inputLine);
				}

				//Set Operands
				if (isNumeric(stringArray[0])) {
					operand1 = Double.parseDouble(stringArray[0]);
				} else {
					repeat = true;
					throw new NotANumberException(stringArray[0]);
				}

				if (isNumeric(stringArray[2])) {
					operand2 = Double.parseDouble(stringArray[2]);
				} else {
					repeat = true;
					throw new NotANumberException(stringArray[2]);
				}

				//Set Operator
				if (stringArray[1].length() == 1 && checkOperator(stringArray[1])) {
					operator = stringArray[1].charAt(0);
				} else {
					repeat = true;
					throw new IllegalOperationException(stringArray[1]);
				}
				//Check for zeros
				if (operand2 == 0) {
					repeat = true;
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

	public static double calcReq(double opnd1, char optr,double opnd2) {
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
