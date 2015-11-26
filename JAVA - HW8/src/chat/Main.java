package chat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server theServer = new Server();
		
		theServer.connectClients();
		
		Thread myThread = new Thread(theServer);
		
		myThread.start();
		
		
	}

}
