package chat;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class ClientA {
	
	PipedReader localReader = new PipedReader();
	
	public void connectPipes(PipedWriter pw) {

		try {
			localReader.connect(pw);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void readIn() {
		
		try {
			
			System.out.print("A read: ");
			while(localReader.ready()) {
				System.out.print("" + (char) localReader.read());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
