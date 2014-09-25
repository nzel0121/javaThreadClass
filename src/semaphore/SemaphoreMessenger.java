package semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreMessenger {
	private final Semaphore semaphore;

	public SemaphoreMessenger(int permitCount) {
		this.semaphore = new Semaphore(permitCount);
	}
	public void sendMessage(String msg){
		new Thread(new Messenger(semaphore,msg)).start();;
	}
	
}
