import java.io.File;
import java.io.IOException;
import java.util.*;
public class JavaSH {
	
	// Scanner Variable
	private static Scanner myScanner = new Scanner(System.in);
	
	//
	private static String userCMD;
	private static String[] userCMDArr;
	
	//
	private static ProcessBuilder myProcess;

	public static void main(String[] args) throws IOException {
/*		// Ask the user to enter a command.
		System.out.print("Your command> ");
		// Get the input
		userCMD = myScanner.nextLine();
		
		userCMDArr = userCMD.split(" ");
		
		// Check the input
		try {
			if (userCMDArr.length == 1) {
				checkCMD(userCMDArr[0]);
			} else if (userCMDArr.length == 3 && userCMDArr[1].equals(">")) {
				redirectCMD(userCMDArr[0], userCMDArr[2]);
			} else {
				System.out.println("You messed up. Sorry");
			}
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		redirectCMD("C:\\Users\\Nika\\Desktop\\tmp\\helloworld.exe", "text.txt");
	}
	public static void redirectCMD(String exe, String file) throws IOException {
		//myProcess = new ProcessBuilder();
		
		String[] cmd = {exe, "-o", file};
		
		Process p = Runtime.getRuntime().exec(cmd);
		
		//myProcess = myProcess.redirectOutput(new File(file));
		
		//myProcess.start();
		
		
	}
	
	public static void checkCMD(String cmd) throws IOException, InterruptedException {
		// Check the ending of cmd
		if (cmd.endsWith("&")) {
			// Remove the & char.
			cmd = cmd.substring(0, (cmd.length()-1));
			nonBlockingCall(cmd);
		} else {
			blockingCall(cmd);
		}
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
