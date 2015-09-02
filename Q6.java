import java.io.IOException;
import java.util.Scanner;

public class Q6 {

	private static Scanner myScanner;
	
	public static void main(String[] args) throws IOException {
		
		myScanner = new Scanner(System.in);
		int[] cirA = new int[2];
		int[] cirB = new int[2];
		int radA = 0, radB = 0;
		
		//Get the coordinates for A.
		System.out.print("Please enter 2D center coordinates for circle A: x: ");
		cirA[0] = myScanner.nextInt();
		System.out.print("Please enter 2D center coordinates for circle A: y: ");
		cirA[1] = myScanner.nextInt();
		System.out.print("Please enter radius for circle A: ");
		radA = myScanner.nextInt();
		
		//Get the coordinates for B.
		System.out.print("Please enter 2D center coordinates for circle B: x: ");
		cirB[0] = myScanner.nextInt();
		System.out.print("Please enter 2D center coordinates for circle B: y: ");
		cirB[1] = myScanner.nextInt();
		System.out.print("Please enter radius for circle B: ");
		radB = myScanner.nextInt();
		
		myScanner.close();
		
		//Let's first find the distance between the centers.
		double disAB = Math.sqrt((Math.pow((cirB[0] - cirA[0]), 2)) + (Math.pow((cirB[1] - cirA[1]), 2)));
		
		//Now let's see what's the sum of radiuses. 
		double sumOfRads = radA + radB;
		
		//Let's compare them.
		if (disAB > sumOfRads) {
			System.out.println("The two circules are seperate.");
		} else if (disAB <= Math.abs(radA - radB)) {
			if (radA > radB) {
				System.out.println("CircleB is inside CircleA");
			} else {
				System.out.println("CircleA is inside CircleB");
			}
		} else {
			System.out.println("The two circules are overlapping each other.");
		}
		
	}//End of main.
}
