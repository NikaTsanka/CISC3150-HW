

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test 1");
		System.out.println("Hi again");
		
		int range = 4;
		
		int count = 0;
		
		for (int i = 1; i <= range; i++) {
			printSpaces(((range + 1) - i));
			
			for (int j = 1; j <= i; j++){
				count = 1;
				System.out.print(range - (range - count)); 
				for (int k = 1; k < j; k = k + j) {
					
					System.out.print(range - (range - (k+j)));
				}
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