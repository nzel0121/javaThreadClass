package semaphore;

public class SemaphoreMain {

	public static void main(String[] args) {
		SemaphoreMessenger semaphoreMessenger = new SemaphoreMessenger(3);
		for (int i = 0; i < 10; i++) {
			semaphoreMessenger.sendMessage("message = " + i);
		}
	}

}
