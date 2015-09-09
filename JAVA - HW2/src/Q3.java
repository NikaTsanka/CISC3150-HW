//This program checks if user entered string is a palindrome.

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Q3 {

	protected static Scanner myScanner;
	protected static String  userString;

	public static void main(String[] args) {
		myScanner  = new Scanner(System.in);
		userString = "";

		int midPoint = 0, startPoint = 0, endPoint = 0;

		try {
			System.out.print("Please enter a string: ");
			userString = myScanner.nextLine();
			if (userString.isEmpty()) {
				throw new StringIndexOutOfBoundsException(
						"Invalid input. Empty String");
			}
		} catch (InputMismatchException ime) {
			System.out.println("Invalid input. Try again. " + ime);
		} catch (NoSuchElementException nsee) {
			System.out.println("Invalid input. Try again. " + nsee);
		} finally {
			//No matter what we need to close the Scanner.
			myScanner.close();
		}

		//Find the midPoint and endPoint, startPoint is always 0.
		endPoint = userString.length() - 1; //Assume 7 - 1 = 6
		midPoint = endPoint / 2; // This would be = 3

		for (int i = 0; i <= midPoint; i++) {
			if (userString.charAt(startPoint) == 
					userString.charAt(endPoint)) {
				//Check next char by incrementing startPoint
				//And decrementing endPoint.
				startPoint += 1;
				endPoint   -= 1;
			} else {
				//If not then the string is not a palindrome.
				//So break and terminate the program :).
				System.out.println("Entered string is not a " +
						"palindrome.");
				System.exit(0);
			}
		}
		//If everything goes fine then it's a palindrome.
		System.out.println("Your string is a palindrome. :)");
	}//End of main.
}//End of the class.
