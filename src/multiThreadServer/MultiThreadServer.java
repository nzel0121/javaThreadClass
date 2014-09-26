package multiThreadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import singleThreadServer.RequestHandler;

public class MultiThreadServer {

	public static void main(String[] args) {
		int serverPort = 8888;
		try {
			ServerSocket serverSocket = new ServerSocket(serverPort);
			System.out.println("Started Server ");
			while (true) {
				System.out.println("waiting client-request");
				Socket socket = serverSocket.accept();
				new Thread(new RequestHandler(socket)).start();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
