/**
 * 
 * @author Nika Tsankashvili
 *
 */
public class Q1 {
	
	//Operand Variables
	private static int operand1, operand2;
	private static double dblOperand1, dblOperand2;
	
	//Operator Variable
	private static char mainOperator;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Number of arguments: " + args.length);
		
		/*
		 * Read in passed arguments
		 * They have to parsed since all args are strings 
		 */
		//Operands
		//operand1 = Integer.parseInt(args[0]);
		//operand2 = Integer.parseInt(args[2]);
		
		//Operator
		//mainOperator = args[1].charAt(0);
		
		
		//System.out.println(operand1 + " " + operand2 + " " + mainOperator);
		
		System.out.println(calcReq(6.4, '*', 3.2));
		
	}
	//Overloaded methods
	public static void calcRequest(int opnd1, char optr,int opnd2){

		if (optr == '+') {
						
		}
	}
	public static int calcReq(int opnd1, char optr,int opnd2) {
		
		int intResult = 0;
		
		if (optr == '+') {
			//Do Addition
			intResult = opnd1 + opnd2;
		} else if (optr == '-') {
			//Subtraction
			intResult = opnd1 - opnd2;
		} else if (optr == '/'){
			//
			intResult = opnd1 / opnd2;
		} else if (optr == '*') {
			//
			intResult = opnd1 * opnd2;
		} else if (optr == '%') {
			//
			intResult = opnd1 % opnd2;
		}
		
		return intResult;
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
