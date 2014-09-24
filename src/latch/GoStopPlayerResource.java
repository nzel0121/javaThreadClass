package latch;

import java.util.concurrent.CountDownLatch;

public class GoStopPlayerResource implements Runnable {
	private final CountDownLatch countDownLatch;
	
	public GoStopPlayerResource(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		composeResource();
		countDownLatch.countDown();
	}

	private void composeResource() {
		System.out.println("Preparing Player Resource");
	}

}
