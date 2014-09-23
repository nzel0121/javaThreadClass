package threadUnSafe;

import java.util.concurrent.TimeUnit;

public class ThreadUnsafeMain {

	public static void main(String[] args) {

		ThreadUnSafeController controller = new ThreadUnSafeController();
		for (int i = 0; i < 1000; i++) {
			Thread requestHandler = new Thread(new RequestHandler(controller));
			requestHandler.start();
		}
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("count = "+ controller.getRequestCount());
		
	}

}
