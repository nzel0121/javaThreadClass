package yieldExample;

public class YieldExample implements Runnable {

	private int count = 0;
	
	public YieldExample(int count) {
		super();
		this.count = count;
	}

	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			Thread t = Thread.currentThread();
			System.out.println(t.getName() +  " Count = " + i);
			Thread.yield();
		}
	}

}
