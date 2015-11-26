package chat;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class ClientB {

	public static Scanner myScanner = new Scanner(System.in);

	//static PipedWriter localWriter = new PipedWriter();

	//static PipedReader localReader = new PipedReader();

	static ReadInB readersB = new ReadInB();
	static WriteOutB writesB = new WriteOutB();
	
	public static void main(String[] args) {

		
		readersB.setReader();
		
		writesB.setWriter();

/*		//new ClientB();
		ReadInB read = new ReadInB();
		WriteOutB write = new WriteOutB();
		
		//read.setReader(localReader);
		//write.setWriter(localWriter);
*/		
		Thread cR = new Thread(readersB);
		Thread cW = new Thread(writesB);
		cR.start();
		cW.start();
	}

/*	public PipedWriter returnWriter() {
		return localWriter;
	}
	
	public PipedReader retLocalReader() {
		return localReader;
	}*/

}
class WriteOutB implements Runnable {
	PipedWriter writer;
	
	public void setWriter() {
		writer = Server.writerFromA;
	}
	
	public void run() {
		
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
	
	PipedReader reader;
	
	//From client A
	public void setReader() {
		reader = Server.readerB;
	}
	
	public void run() {
		
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
