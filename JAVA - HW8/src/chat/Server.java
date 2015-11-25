package chat;

import java.io.PipedWriter;

public class Server {

	public void connectClients() {
		ClientA clientA = new ClientA();
		ClientB clientB = new ClientB();
		
		PipedWriter writerFromBtoA = clientB.returnWriter();
		
		//Need writerobject form clientB
		
		
		
		clientA.connectPipes(writerFromBtoA);
		
		clientB.writeOut();
		
		clientA.readIn();

	}

}
