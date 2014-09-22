package priorityExample;

public class PriorityExampleMain {

	public static void main(String[] args) {
		int count = 10;
		Thread t1 = new Thread(new PriorityExample(count));
		t1.setPriority(Thread.MIN_PRIORITY);
		Thread t2 = new Thread(new PriorityExample(count));
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
	}

}
