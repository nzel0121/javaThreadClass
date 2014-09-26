package singleThreadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleServer {

	public static void main(String[] args) {
		int serverPort = 8888;
		try {
			ServerSocket serverSocket = new ServerSocket(serverPort);
			System.out.println("Started Server ");
			while(true){
				System.out.println("waiting client-request");
				Socket socket = serverSocket.accept();
				new RequestHandler(socket).run();
			}
		} catch (IOException e) {

				System.out.println(e.getMessage());
		}
	}

}
