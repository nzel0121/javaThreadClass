package barrier;

import java.util.concurrent.CyclicBarrier;

public class GoStopBarrierMain {
	public static final int playCount = 3;

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(playCount, new Runnable() {

			@Override
			public void run() {

				System.out.println("If Resource Loaded Start Game");
			}

		});
		for (int i = 0; i < playCount; i++) {
			Thread t1 = new Thread(new GoStopPlayerResource(barrier));
			t1.start();
		}

	}

}
