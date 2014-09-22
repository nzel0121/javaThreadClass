package runnableHello;

public class RunnableHelloWorld implements Runnable {

	private int count=0;
	
	public RunnableHelloWorld(int count) {
		super();
		this.count = count;
	}

	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println("Hello World Count = " +  i);
		}
	}

}
