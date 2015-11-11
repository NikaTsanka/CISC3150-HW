/**
 * 
 * @author Nika Tsankashvili
 *
 */
public class Q1 {
	
	//Operand Variables
	private static double operand1, operand2;
	
	//Operator Variable
	private static char operator;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Number of arguments: " + args.length);
		
		/*
		 * Read in passed arguments
		 * They have to parsed since all args are strings 
		 */
		//Operands
		operand1 = Double.parseDouble(args[0]);
		operand2 = Double.parseDouble(args[2]);
		
		//Operator
		if (args[1].length() == 1) {
			operator = args[1].charAt(0);
		} else {
			System.out.println("agadg");
		}
		
		
		
		System.out.println(operand1 + " " + operator + " " + operand2);
		
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
	
	
	
	
//	for (int i = 0; i < args.length; i++) {
//	System.out.print(args[i]);
//}

//try {
//	if (args.length == numOfArgs) {
//		
//	} else {
//		//throw new NotEnoughNumbersException();
//	}
//} catch (Exception e) {
//	
//}
}
