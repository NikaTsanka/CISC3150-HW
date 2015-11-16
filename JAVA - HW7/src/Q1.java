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

		//setStartingPoint();

		//fileObj = new File(startingPoint + ":\\");

		fileObj = new File("D:\\Torrent Downloads\\Others");

		out.println(fileObj.getAbsolutePath());

		/*File[] pathList = fileObj.listFiles();

		for (int i = 0; i < pathList.length; i++) {
			out.println(pathList[i].getAbsolutePath());
		}*/
		seekAndPrint(fileObj);

	}

	public void seekAndPrint(File filePath) {
		File[] pathList = filePath.listFiles();

		for (int i = 0; i < pathList.length; i++) {
			//File tmpFileObj = new File(filePath.getPath() + pathList[i]);

			if (pathList[i].isDirectory() && !(pathList[i].isHidden())) {
				out.print("---" + pathList[i].getName());
				out.println();
				seekAndPrint(pathList[i]);

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
