package chat;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class ClientA {// implements Runnable

	public static Scanner myScanner = new Scanner(System.in);

	//public static PipedReader localReader = new PipedReader();

	//public static PipedWriter localWriter = new PipedWriter();

	static ReadInA readersA = new ReadInA();
	static WriteOutA writesA = new WriteOutA();
	
	public static void main(String[] args) {

		//new ClientA();
		readersA.setReader();
		writesA.setWriter();


		Thread cR = new Thread(readersA);
		Thread cW = new Thread(writesA);
		cR.start();
		cW.start();
	}

/*	public ReadInA getLocalReader() {
		return 
	}

	public PipedWriter returnWriter() {
		return localWriter;
	}*/

}

class WriteOutA implements Runnable {

	PipedWriter writer;

	public void setWriter() {
		writer = Server.writerFromB;
	}



	public void run() {

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

	PipedReader reader;

	//From client B
	public void setReader() {
		reader = Server.readerA;
	}

	public void run() {

		try {
			if (reader.ready()) {
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
