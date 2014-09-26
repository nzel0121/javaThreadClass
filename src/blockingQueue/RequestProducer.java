package blockingQueue;

import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestProducer implements Runnable {


	private volatile Socket socket;
	private volatile LinkedBlockingQueue<Socket> queue;

	public RequestProducer(Socket socket, LinkedBlockingQueue<Socket> queue) {
		super();
		this.socket = socket;
		this.queue = queue;
	}

	@Override
	public void run() {
		queue.add(socket);
	}

}
