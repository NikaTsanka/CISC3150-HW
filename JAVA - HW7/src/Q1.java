import java.io.File;
import java.util.Scanner;
import static java.lang.System.out;

public class Q1 {
	
	private String startingPoint = " ";
	
	private File fileObj;
	
	private static Scanner myScanner = new Scanner(System.in);;

	public Q1() {
		
	}
	
	public void setFile() {
		
		//First set the path
		
		setStartingPoint();
		
		fileObj = new File(startingPoint + ":\\");
		
		out.println(fileObj.getAbsolutePath());
		
		
		
		
	}
	
	public void seekAndPrint(File filePath) {
		String[] pathList = filePath.list();
		for (int i = 0; i < pathList.length; i++) {
			if (pathList[i].d) {
				
			} else {

			}
		}
	}
	
	//Method to set startingPoint
	public void setStartingPoint() {
		out.print("Which Drive: ");
		
		startingPoint = myScanner.next();
	}

	public boolean checkPath(File filePath) {
		
		//First check if it exists 
		if (filePath.exists()) {
			//Then check if its a file
			if (filePath.isFile()) {
				//Then check if its a directory
				if (filePath.isDirectory()) {
					return true;
				} else {
					out.println(filePath + ": is not a directory");
					return false;
				}
			} else {
				out.println(filePath + ": is not a file");
				return false;
			}
		} else {
			out.println(filePath + ": does not exist");
			return false;
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q1 testObj = new Q1();
		
		testObj.setFile();
	}

}
