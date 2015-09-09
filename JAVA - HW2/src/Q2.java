import java.util.InputMismatchException;
import java.util.Scanner;

public class Q2 {
	protected static Scanner myScanner;
	protected static int year, fDay, numOfDays;
	protected static String month;

	public static void main(String[] args) {
		myScanner = new Scanner(System.in);
		year = 0;

		try {
			System.out.print("What year? ");
			year = myScanner.nextInt();

			System.out.print("Enter the first day of " + 
					"January: 1-7 inclusive: ");
			fDay = myScanner.nextInt();

			if (fDay <= 0 || fDay > 7) {
				throw new InputMismatchException();
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input! try again.");
		} finally {
			myScanner.close();
		}
		
		
		for (int index = 1; index <= 12; index++) {
			setMonths(index);
			printPattern();
			printDayNums();
		}
		
	}
	public static void printDayNums() {
		//Add spacing according to the starting day
		for (int i = 0; i < fDay; i++) {
			System.out.printf("   ");			
		}
		for (int i = 1; i < numOfDays + 1; i++) {
			if (fDay%7==0 && fDay!=0)
				System.out.println();
			System.out.printf("%1d  ", i);
			fDay+=1;
		}
		numOfDays%=7;
		System.out.println();
		
		
	}
	
	
	public static void printPattern() {
		System.out.printf("%-3s - %2d", month, year);
		System.out.println();
		System.out.println("Su Mo Tu We Th Fr Sa");
		
	}
	public static void setMonths (int num) {
		month = "";
		numOfDays = 0;
		switch(num){
			case 1: 
				month = "January";
				numOfDays = 31;
				break;
			case 2: 
				month = "February";
				numOfDays = leapYears(year);
				break;
			case 3: 
				month = "March";
				numOfDays = 31;
				break;
			case 4: 
				month = "April";
				numOfDays = 30;
				break;
			case 5: 
				month = "May";
				numOfDays = 31;
				break;
			case 6: 
				month = "June";
				numOfDays = 30;
				break;
			case 7: 
				month = "July";
				numOfDays = 31;
				break;
			case 8: 
				month = "August";
				numOfDays = 31;
				break;
			case 9: 
				month = "September";
				numOfDays = 30;
				break;
			case 10: 
				month = "October";
				numOfDays = 31;
				break;
			case 11: 
				month = "November";
				numOfDays = 30;
				break;
			case 12: 
				month = "December";
				numOfDays = 31;
				break;
		}
	}
	//I didn't know how to calculate this so I looked it up.
	public static int leapYears(int y) {
		if (((y %4 == 0) && (y %100 != 0)) || (y %400 == 0)) {
			return 29;
		} else {
			return 28;
		}
	}
}