package joinExample;

import java.util.concurrent.TimeUnit;

public class ResourceLoader implements Runnable {
	
	@Override
	public void run() {
		try {
			System.out.println("load resources");
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
