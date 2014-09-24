package atomicityExample;

import java.util.concurrent.TimeUnit;

public class AtomicityMain {

	public static void main(String[] args) {
		AtomicityCounter atomicityCounter = new AtomicityCounter();
		for (int i = 0; i < 1000; i++) {
			Thread t1 = new Thread(new RequestHandler(atomicityCounter));
			t1.start();
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("countert =  "+ atomicityCounter.getCount());
	}

}
