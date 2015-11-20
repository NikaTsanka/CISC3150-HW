package chat;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.*;

public class ClientA {

	public static void main(String[] args) {
		// Set up pipes
		try {
			PipedOutputStream localPOS = new PipedOutputStream();
			
			PipedInputStream localPIS = new PipedInputStream(localPOS);
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
		
		

	}

}
