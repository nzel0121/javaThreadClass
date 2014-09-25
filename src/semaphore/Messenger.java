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
			System.out.println("��밡���� ���� ���� = " + semaphore.availablePermits());
			semaphore.acquire();
			System.out.println("������ ȹ�� msg ���� = " + msg);
			
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			semaphore.release();
		}
		
	}

}
