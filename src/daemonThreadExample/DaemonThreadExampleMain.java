package daemonThreadExample;

import java.util.concurrent.TimeUnit;

public class DaemonThreadExampleMain {

	public static void main(String[] args) {

		Thread daemonThread = new Thread(new DaemonThreadExample());
		daemonThread.setDaemon(true);
		daemonThread.start();
		
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
