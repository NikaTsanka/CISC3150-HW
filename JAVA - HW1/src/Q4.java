import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) throws IOException {

		Scanner myScanner = new Scanner(new InputStreamReader(System.in));
		String lineVal;

		System.out.println("Here is your text file content");

		//Display the file content.
		try {
			while (myScanner.hasNextLine()) {
				lineVal = myScanner.next();
				System.out.println(lineVal);
			}
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			myScanner.close();
			System.out.println("The End.");
		}
	}//End of main.
}
