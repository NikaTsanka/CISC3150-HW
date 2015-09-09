//Simple labels at work.
public class Q4 {

	public static void main(String[] args) {
		//Break check
		int outerCount = 10, innercount = 10;;
		outerloop:
		for (int i = 0; i < outerCount; i++) {
			for (int j = 0; j < innercount; j++) {
				System.out.println("Outer For is at: " + i + 
								   " Inner For is at: " + j);
				if (i == 5 && j == 5) {
					System.out.println("Break here");
					break outerloop;
				}//If
			}//Inner For
		}//Outer For
		System.out.println("And we are out of the nested loop. :)");
	}
}
