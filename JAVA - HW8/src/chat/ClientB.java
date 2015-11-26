package chat;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class ClientB {

	public static Scanner myScanner = new Scanner(System.in);

	static PipedWriter localWriter = new PipedWriter();

	static PipedReader localReader = new PipedReader();

	public static void main(String[] args) {


		new ClientB();
		Thread cR = new Thread(new ReadInB());
		Thread cW = new Thread(new WriteOutB());
		cR.start();
		cW.start();
	}

	public PipedWriter returnWriter() {
		return localWriter;
	}
	
	public PipedReader retLocalReader() {
		return localReader;
	}

	public void connectPipes(PipedWriter pw) {

		try {
			localReader.connect(pw);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
class WriteOutB implements Runnable {
	public static PipedWriter writer = null;
	
	public void run() {
		
		ClientA localClient = new ClientA();
		
		writer = localClient.returnWriter();
		
		
		try {
			System.out.print("Message to A: ");
			String msgStr = ClientB.myScanner.next();
			writer.write(msgStr);
			// Signal the server that A's message can be read
			Thread.sleep(1000);

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ReadInB implements Runnable {
	
	public static PipedReader reader = null;
	
	public void run() {
		
		ClientA localClient = new ClientA();
		
		reader = localClient.retLocalReader();
		
		try {
			if (reader.ready()) {
				System.out.print("Client B received: ");
				while(reader.ready()) {
					System.out.print("" + (char) reader.read());
				}
				reader.reset();
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
}
