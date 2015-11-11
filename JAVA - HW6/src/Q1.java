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

	public Q1(String opnd1, String optr, String opnd2) throws NotANumberException {
		setArguments(opnd1, optr, opnd2);
	}

	public void setArguments(String opnd0, String optr, String opnd2)
			throws NotANumberException {



		try {
			//Set Operands
			try {
				operand1 = Double.parseDouble(opnd0);
				//If everything is fine then no need to repeat.
				
			} catch (NumberFormatException nfe) {
				throw new NotANumberException(opnd0);
			}
			try {
				operand2 = Double.parseDouble(opnd2);
				//If everything is fine then no need to repeat.
				
			} catch (NumberFormatException nfe) {
				throw new NotANumberException(opnd2);
			}

			//Set Operator
			try {
				if (optr.length() == 1 && checkOperator(optr)) {
					operator = optr.charAt(0);
				} 
			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (NotANumberException nane){

		}


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

	public static void main(String[] args) throws NotANumberException {
		// TODO Auto-generated method stub
		//boolean continueInput = false;
		//System.out.println("Number of arguments: " + args.length);
		//do {

			try {
				myScanner = new Scanner(System.in);
				inputLine = myScanner.nextLine();
				inputLineToArray = inputLine.split(" ");
				
				new Q1(inputLineToArray[0], inputLineToArray[1], inputLineToArray[2]);
				
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				myScanner.close();
			}
		//} while (continueInput);


		//System.out.println(operand1 + " " + operator + " " + operand2);

		System.out.println(calcReq(operand1, operator, operand2));

	}
	//Overloaded methods
	public static void calcRequest(int opnd1, char optr,int opnd2){

		if (optr == '+') {

		}
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
}
