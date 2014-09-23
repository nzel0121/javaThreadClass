package joinExample;

public class Calculator implements Runnable {

	private ResourceLoader resourceLoader; 
	public Calculator(ResourceLoader resourceLoader) {
		super();
		this.resourceLoader = resourceLoader;
	}
	@Override
	public void run() {
		Thread t1 = new Thread(resourceLoader);
		t1.start();
		try {
			t1.join();
			System.out.println("start calculate");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
