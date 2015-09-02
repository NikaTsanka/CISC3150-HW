import java.util.InputMismatchException;
import java.util.Scanner;
public class Q5 {

	private static Scanner myScanner;

	public static void main(String[] args) {

		myScanner = new Scanner(System.in);
		int[] a = new int[2];
		int[] b = new int[2];
		int[] c = new int[2];
		int flag = 0;
		
		System.out.println("Hi, please enter 3 2D points");
		
		//Get the coordinates for A.

		try {
			System.out.print("A: x = ");
			a[0] = myScanner.nextInt();
			System.out.print("A: y = ");
			a[1] = myScanner.nextInt();
			
			//Get the coordinates for B.
			System.out.print("B: x = ");
			b[0] = myScanner.nextInt();
			System.out.print("B: y = ");
			b[1] = myScanner.nextInt();	
			
			//Get the coordinates for C.
			System.out.print("C: x = ");
			c[0] = myScanner.nextInt();
			System.out.print("C: y = ");
			c[1] = myScanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input: " + e);
			System.out.println("The Program is terminated ");
			System.exit(0);
		} finally {
			myScanner.close();
		}
		
		//Display the entered data.
		System.out.println("You Entered: A: (" + a[0] + "," + a[1] + ")");
		System.out.println("You Entered: B: (" + b[0] + "," + b[1] + ")");
		System.out.println("You Entered: C: (" + c[0] + "," + c[1] + ")");
		
		//Calculate the distances.
		double disAB = Math.sqrt((Math.pow((b[0] - a[0]), 2)) + (Math.pow((b[1] - a[1]), 2)));
		double disBC = Math.sqrt((Math.pow((c[0] - b[0]), 2)) + (Math.pow((c[1] - b[1]), 2)));
		double disCA = Math.sqrt((Math.pow((a[0] - c[0]), 2)) + (Math.pow((a[1] - c[1]), 2)));
		
		//Display the distances.
		System.out.println("Distance between A to B is: " + disAB);
		System.out.println("Distance between B to C is: " + disBC);
		System.out.println("Distance between C to A is: " + disCA);
		
		//Now let's check if it's a real triangle.
		if ((disAB + disBC) > disCA) {
			flag++;
		} 
		if ((disAB + disCA) > disBC) {
			flag++;
		}
		if ((disBC + disCA) > disAB) {
			flag++;
		}
		
		//Display the result.
		if (flag == 3) {
			System.out.println("Triangle is valid");
		} else {
			System.out.println("Triangle is invalid");
		}
	}//End of main.
}
