package daemonThreadExample;

import java.util.concurrent.TimeUnit;

public class DaemonThreadExample implements Runnable {

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("insert Daemon Thread");
				TimeUnit.MILLISECONDS.sleep(1);
			}
		} catch (InterruptedException e) {
			System.out.println("InterruptException!!");
		}finally{
			System.out.println("DaemonThread Example's finally run!");
		}
	}

}
