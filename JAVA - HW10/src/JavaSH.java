import java.io.File;
import java.io.IOException;
import java.util.*;

public class JavaSH {

	// Scanner Variable
	private static Scanner myScanner = new Scanner(System.in);

	// User string input variables
	private static String userCMD;
	private static String[] userCMDArr;

	// Static ProcessBuilder. So it can be used in all methods.
	private static ProcessBuilder myProcess;

	public static void main(String[] args) throws IOException {
		// Ask the user to enter a command.
		System.out.print("Your command> ");
		// Get the input
		userCMD = myScanner.nextLine();
		// Split the input.
		userCMDArr = userCMD.split(" ");

		// Check the inputs
		try {
			if (userCMDArr.length == 1) {
				checkCMD(userCMDArr[0]);
			} else if (userCMDArr.length == 3 && userCMDArr[1].equals(">")) {
				redirectCMD(userCMDArr[0], userCMDArr[2]);
			} else {
				System.out.println("You messed up. Sorry");
			}
		} catch (IOException | InterruptedException e) {
			System.out.println("Ooooooooh. You did something wrong." + e);
		}
	}

	public static void checkCMD(String cmd) throws IOException, InterruptedException {
		// Check the ending of cmd
		if (cmd.endsWith("&")) {
			// Remove the & char.
			cmd = cmd.substring(0, (cmd.length()-1));
			// call the nonblocking method.
			nonBlockingCall(cmd);
		} else {
			// call blocking method.
			blockingCall(cmd);
		}
	}
	
	public static void redirectCMD(String exe, String file) throws IOException {
		// File has to exist for output. 
		File outPutFile = new File(file);	

		// Check the ending of cmd
		myProcess = new ProcessBuilder();

		// Set the command.
		myProcess.command(exe);

		// Set the output file
		myProcess = myProcess.redirectOutput(outPutFile);

		// Start the process. 
		myProcess.start();
		
		System.out.println("0");
	}

	public static void nonBlockingCall(String cmd) throws IOException {
		// Create the process
		myProcess = new ProcessBuilder(cmd);
		// Start the process without blocking
		myProcess.start();

		System.out.println("0");
	}

	public static void blockingCall(String cmd) throws IOException, InterruptedException {
		// Create the process
		myProcess = new ProcessBuilder(cmd);

		// Start the process with blocking
		// Doesn't work with native methods
		// "calc" is native. "notepad" is not. 
		Process p = myProcess.start();
		// get the exitcode
		int exit = p.waitFor();
		// print.
		System.out.println("Dude. What took you so long?");
		System.out.println(exit);
	}
}
