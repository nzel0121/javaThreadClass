package threadUnSafe;

public class RequestHandler implements Runnable {
	private ThreadUnSafeController controller;
	
	public RequestHandler(ThreadUnSafeController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void run() {
		controller.service(null);
	}

}
