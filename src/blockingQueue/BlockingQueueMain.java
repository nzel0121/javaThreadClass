package blockingQueue;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueMain {
	private static volatile LinkedBlockingQueue<Socket> queue = new LinkedBlockingQueue<Socket>();
	private static final int nThreads = 100;
	private static final Executor produceExecutor = Executors.newFixedThreadPool(nThreads);
	private static final Executor consumerExecutor = Executors.newFixedThreadPool(nThreads);
	
	public static void main(String[] args) throws IOException {

		int serverPort = 8888;
		ServerSocket serverSocket = new ServerSocket(serverPort);
		System.out.println("started server");
		
		while(true){
			System.out.println("waiting client request.");
			final Socket socket = serverSocket.accept();
			produceExecutor.execute(new RequestProducer(socket,queue));
			consumerExecutor.execute(new RequestConsumer(queue));
		}
	}

}
