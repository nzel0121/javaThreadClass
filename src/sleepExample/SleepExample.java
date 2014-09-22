package sleepExample;

import java.util.concurrent.TimeUnit;

public class SleepExample implements Runnable {

	private int count = 0;
	
	public SleepExample(int count) {
		super();
		this.count = count;
	}

	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println("Hello World count = " + i);
			try {
				Thread.sleep(1000);
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("인터럽트 발생");
			}
		}
	}

}
