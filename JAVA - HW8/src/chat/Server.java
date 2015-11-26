package chat;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Server implements Runnable {
	
	PipedReader serverReaderFromCA = null;
	PipedReader serverReaderFromCB = null;
	
	ClientA clientA = new ClientA();
	ClientB clientB = new ClientB();
	
	PipedWriter writerFromBtoA = clientB.returnWriter();
	PipedWriter writerFromAtoB = clientA.returnWriter();

	public void connectClients() {
		//Connect the pipes first
		clientA.connectPipes(writerFromBtoA);
		clientB.connectPipes(writerFromAtoB);
		
	}
	
	public void run() {
		
		connectClients();
		
		try {
			
			serverReaderFromCA = clientA.retLocalReader();
			
			serverReaderFromCB = clientB.retLocalReader();
			
			while (true) {
				while(serverReaderFromCA.ready()) {
					System.out.print("" + (char)serverReaderFromCA.read());
				}
				//System.out.println();
				
				while(serverReaderFromCB.ready()) {
					System.out.print("" + (char) serverReaderFromCB.read());
				}
				//System.out.println();
			}	
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
