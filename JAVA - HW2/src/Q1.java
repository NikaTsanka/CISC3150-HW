import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		System.out.print("Please enter how tall " + 
						   "you want your pyramid ");

		@SuppressWarnings("resource")
		int range = new Scanner(System.in).nextInt();
		
		for (int i = 1; i <= range; i++) {
			
			printSpaces((range - i));
			
			for (int j = 1; j <= i; j++){
				System.out.printf("%1d", j);
			}
			for (int k = 1; k <= i-1; k++){
				System.out.printf("%1d", i-k);
			}

			System.out.println();
		}
	}
	public static void printSpaces(int numOfS) {
		for (int i = 1; i <= numOfS; i++) {
			System.out.printf("%-1s", " ");	
		}
	}
}