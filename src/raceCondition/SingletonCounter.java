package raceCondition;

import java.util.concurrent.TimeUnit;

public class SingletonCounter {
	private static SingletonCounter singleton;
	private long count = 900000000000000L;
	
	public static SingletonCounter getInstance(){
		if(singleton == null){
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			singleton = new SingletonCounter();
		}
		return singleton;
	}
	public void increment(){
		count++;
	}
	public long getCount() {
		return count;
	}
	
}
