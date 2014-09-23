package threadSafe;

public class RequestHandler implements Runnable {
	private ThreadSafeController controller;
	
	public RequestHandler(ThreadSafeController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void run() {
		controller.service(null);
		System.out.println("result = " + Context.local.get());
	}

}
