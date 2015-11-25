package chat;

import java.io.IOException;
import java.io.PipedWriter;

public class ClientB {
	
	PipedWriter localWriter = new PipedWriter();
	
	

	public PipedWriter returnWriter() {
		return localWriter;
	}
	
	public void writeOut() {
		try {
			localWriter.write("Hey, Heyyyyyyyyyyyyyyyy");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
