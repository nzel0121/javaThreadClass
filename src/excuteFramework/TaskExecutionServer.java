package excuteFramework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import singleThreadServer.RequestHandler;

public class TaskExecutionServer {

	private static final int threadPool = 100;
	private static final Executor exec = Executors.newFixedThreadPool(threadPool);
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			int serverPort = 8888;
			serverSocket = new ServerSocket(serverPort);
			System.out.println("started server");
			
			//while(!Thread.currentThread().isInterrupted())
			
			while(true){
				System.out.println("waiting client-request");
				final Socket socket = serverSocket.accept();
				exec.execute(new RequestHandler(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
