package barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class GoStopPlayerResource implements Runnable {

	private final CyclicBarrier barrier;
	
	public GoStopPlayerResource(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}

	@Override
	public void run() {

		composeResource();
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	private void composeResource() {

		System.out.println("Compose Player Resource ");
	}

}
