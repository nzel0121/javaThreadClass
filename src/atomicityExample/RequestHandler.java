package atomicityExample;

public class RequestHandler implements Runnable {

	private AtomicityCounter atomicityCounter;
	
	public RequestHandler(AtomicityCounter atomicityCounter) {
		super();
		this.atomicityCounter = atomicityCounter;
	}

	@Override
	public void run() {
		atomicityCounter.increment();
	}

}
