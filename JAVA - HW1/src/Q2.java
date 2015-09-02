import java.util.*;

public class Q2 {

	final protected static int RESET = 0;
	public static void main(String[] args) {
	
		Scanner myScanner = new Scanner(System.in);
		double radius = 0;
		try {
			do {
				System.out.print("Enter the radius: ");
				
				radius = myScanner.nextDouble();
				
				if (radius == 0) {
					System.out.println("Invalid number entered!");
					System.out.println("Radius cannot be 0.");
				} else if (radius < 0) { 
					System.out.println("Invalid number entered!");
					System.out.println("Please enter a positive number.");
				} else {
					System.out.println("Your circles area is: " + calcArea(radius));
				}
				
				radius = RESET;
				
			} while(myScanner.hasNextLine());
		} catch (NoSuchElementException e) {
			System.out.println("The Program is terminated ");
		} finally {
			myScanner.close();
			System.out.println("The End.");
		}
	}
	public static double calcArea(double radius) {
		double area = Math.PI * Math.pow(radius, 2.0);
		return Math.round(area * 1e3) / 1e3;
	}
}
