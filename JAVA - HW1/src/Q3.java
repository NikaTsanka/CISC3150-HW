import java.util.Random;

public class Q3 {

	public static void main(String[] args) {
		
		String[] months = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE",
				  "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
		Random rndGen = new Random();
		
		//This will generate random numbers between 0 - 11 inclusive.
		int sysChoice = rndGen.nextInt(12);
		
		System.out.println(months[sysChoice]);

	}//End of main.
}
