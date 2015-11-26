package chat;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Server implements Runnable {
		
	static PipedReader readerA = null;
	static PipedReader readerB = null;
	
	static PipedWriter writerFromA = new PipedWriter();
	static PipedWriter writerFromB = new PipedWriter();
	

	
	
	
/*	public static ReadInA getReadA() {
		return readersA;
	}
	
	public static ReadInB getReadB() {
		return readersB;
	}*/
	

	public void connectClients() {
		//Connect the pipes first
		//clientA.connectPipes(writerFromBtoA);
		//clientB.connectPipes(writerFromAtoB);
		try {
			readerA = new PipedReader(writerFromB);
			readerB = new PipedReader(writerFromA);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
/*	public PipedReader getReaderA() {
		return readerA;
	}
	
	public PipedReader getReaderB() {
		return readerB;
	}*/
	
	
	public void run() {
		
/*		Thread t1A = new Thread(readersA);
		Thread t2A = new Thread(writesA);
		
		t1A.start();
		t2A.start();
		
		Thread t1B = new Thread(readersB);
		Thread t2B = new Thread(writesB);
		
		t1B.start();
		t2B.start();*/
		
		try {
			
			//serverReaderFromCA = clientA.retLocalReader();
			
			//serverReaderFromCB = clientB.retLocalReader();
			
			while (true) {
				while(readerA.ready()) {
					System.out.print("" + (char)readerA.read());
				}
				//System.out.println();
				
				while(readerB.ready()) {
					System.out.print("" + (char) readerB.read());
				}
				//System.out.println();
			}	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
