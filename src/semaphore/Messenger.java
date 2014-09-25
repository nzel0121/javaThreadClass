package semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Messenger implements Runnable {
	private final Semaphore semaphore;
	private final String msg;
	
	public Messenger(Semaphore semaphore, String msg) {
		super();
		this.semaphore = semaphore;
		this.msg = msg;
	}

	@Override
	public void run() {
		try {
			System.out.println("사용가능한 권한 개수 = " + semaphore.availablePermits());
			semaphore.acquire();
			System.out.println("사용권한 획득 msg 전달 = " + msg);
			
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			semaphore.release();
		}
		
	}

}
