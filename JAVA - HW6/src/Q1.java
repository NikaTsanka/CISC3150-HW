import java.util.Scanner;
import static java.lang.System.out;
/**
 * This program can perform command line calculations.
 * @author Nika Tsankashvili 
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

	public static void main(String[] args) {
		//Class Object
		Q1 workingObj = new Q1();

		//Pass args to the set arguments method.
		workingObj.setArguments(args);
	}
	//This method sets the arguments and calls the calculator method.
	public void setArguments(String[] stringArray) {
		
		//Loop control variables
		boolean continueInput = true;
		boolean repeat = false;

		do {
			try {
				//If everything does fine then there is no need to ask
				//the user for the input.
				if (repeat) {
					//Open scanner and get the input from the user
					myScanner = new Scanner(System.in);
					out.print("Please re-enter your arguments: ");
					inputLine = myScanner.nextLine();
					stringArray = inputLine.split(" ");
				}
				//Check for not enough arguments
				if (stringArray.length != 3) {
					repeat = true;
					throw new NotEnoughNumbersException(inputLine);
				}
				//Set Operand1
				if (isNumeric(stringArray[0])) {
					operand1 = Double.parseDouble(stringArray[0]);
				} else {
					repeat = true;
					throw new NotANumberException(stringArray[0]);
				}
				//Set Operand2
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
				//Check for divisor
				if (operand2 == 0) {
					repeat = true;
					throw new ArithmeticException("Divisor cannot be zero");
				}
				//If everything is fine then no need to repeat.
				continueInput = false;
				out.println(calcReq(operand1, operator, operand2));

			} catch (NotANumberException | IllegalOperationException | 
					NotEnoughNumbersException | ArithmeticException ce){
				out.println(ce.getMessage());
			}//End of try/catch
		} while (continueInput);

	}
	//This method performs the calculations
	public static double calcReq(double opnd1, char optr, double opnd2) {
		//This will hold the result
		double dblResult = 0;

		if (optr == '+') {
			dblResult = opnd1 + opnd2;
		} else if (optr == '-') {
			dblResult = opnd1 - opnd2;
		} else if (optr == '/'){
			dblResult = opnd1 / opnd2;
		} else if (optr == '*') {
			dblResult = opnd1 * opnd2;
		} else if (optr == '%') {
			dblResult = opnd1 % opnd2;
		}
		return dblResult;
	}
	//Checks if the operators are valid
	public static boolean checkOperator(String optr) {		
		if (optr.equals("+")) {
			return true;
		} else if (optr.equals("-")) {
			return true;
		} else if (optr.equals("/")){
			return true;
		} else if (optr.equals("*")) {
			return true;
		} else if (optr.equals("%")) {
			return true;
		} else {
			return false;
		}
	}
	/* Citation
	 * http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-a-numeric-type-in-java
	 */
	//Checks if the argument is numeric
	public static boolean isNumeric(String str) {  
		try {  
			@SuppressWarnings("unused")
			double d = Double.parseDouble(str);  
		} catch(NumberFormatException nfe) {  
			return false;  
		}  
		return true;  
	}
}
