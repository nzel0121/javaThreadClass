package threadSafe;

public class ThreadSafeMain {

	public static void main(String[] args) {

		Thread requestHandler = new Thread(new RequestHandler(new ThreadSafeController()));
		requestHandler.start();
	}

}
