package chat;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class ClientA {// implements Runnable

	public static Scanner myScanner = new Scanner(System.in);

	public static PipedWriter localWriter = new PipedWriter();

	public static PipedReader localReader = new PipedReader();
	

	public static void main(String[] args) {

		new ClientA();
		
		Thread cR = new Thread(new ReadInA());
		Thread cW = new Thread(new WriteOutA());
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
			System.out.println(e);
		}
	}
}

class WriteOutA implements Runnable {
	
	public static PipedWriter writer = null;
	
	public void run() {
		
		ClientA localClient = new ClientA();
		
		writer = localClient.returnWriter();
		
		
		try {
			System.out.print("Message to B: ");
			String msgStr = ClientA.myScanner.next();
			writer.write(msgStr);
			// Signal the server that A's message can be read
			Thread.sleep(1000);

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ReadInA implements Runnable {
	
	public static PipedReader reader = null;
	
	public void run() {
		
		ClientA localClient = new ClientA();
		
		reader = localClient.retLocalReader();
		
		try {
			if (ClientA.localReader.ready()) {
				System.out.print("Client A received: ");
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
