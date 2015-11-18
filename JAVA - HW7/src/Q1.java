import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q1 {
	// Scanner Variable
	private Scanner myScanner = new Scanner(System.in);
	// Create the output file.
	private File OutPutFile = new File("dir_tree.txt");
	// PrintWriter object for outputing to a file.
	private PrintWriter output;
	// String variable for storing filepath.
	private String startingPoint;
	// The main file object.
	private File fileObj;
	// Directory counter.
	private int numOfDir;

	public Q1() {
		try {
			// Create PrintWriter object to write to the file.
			output = new PrintWriter(OutPutFile);
			// Call function to set the root directory.
			setRoot();
			// Call function to search and print.
			seekAndprint(fileObj, 0);
			// Output on the console.
			System.out.println("Total number of directories: " + numOfDir);
		} catch (IOException e) {
			System.out.println("Yep something definitely went wrong");
			e.printStackTrace();
		} finally {
			output.close();
		}
	}

	private void setRoot() throws FileNotFoundException {
		// First set the root directory path.
		System.out.print("Which Drive: ");
		startingPoint = myScanner.next();

		// Create the File object
		fileObj = new File(startingPoint + ":\\");

		// Check if the drive is valid.
		if (!checkPath(fileObj)) {
			throw new FileNotFoundException();
		}
		// Inform the user which file system will be printed.
		System.out.println(fileObj.getAbsolutePath() +
				" file system will be printed in " + 
				OutPutFile.getName());
	}

	private void seekAndprint(File fileObj, int numOfTabs) {
		// Create a local array of files in the current directory
		File[] pathList = fileObj.listFiles();
		// Go through the array of files.
		for (int i = 0; i < pathList.length; i++) {
			// Check if it's a directory and it's not hidden.
			if (pathList[i].isDirectory() && !(pathList[i].isHidden())) {
				// Print tabs.
				for (int j = 0; j < numOfTabs; j++) {
					output.print("\t");
				}
				// Print the result to file.
				output.print("[ " + pathList[i].getName() + " ] \n");
				// Increase total count of directories. 
				numOfDir++;
				// Call the function and increase number of tabs.
				seekAndprint(pathList[i], numOfTabs + 1);
			}// End of if()
		}// End of for()
	}// End of seekAndprint()

	private boolean checkPath(File filePath) {
		//First check if it exists 
		if (filePath.exists()) {
			//Then check if its a directory
			if (filePath.isDirectory()) {
				return true;
			} else {
				System.out.println(filePath + " is not a directory");
				return false;
			}// End of nested if()
		} else {
			System.out.println(filePath + " does not exist");
			return false;
		}	
	}

	public static void main(String[] args) {
		new Q1();
	}
}