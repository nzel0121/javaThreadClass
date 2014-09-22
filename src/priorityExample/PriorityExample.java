package priorityExample;

public class PriorityExample implements Runnable {

	private int count = 0;
	
	
	public PriorityExample(int count) {
		super();
		this.count = count;
	}


	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			Thread t = Thread.currentThread();
			double burdenCalc1 = Math.PI + Math.E/(double)i;
			double burdenCalc2 = Math.PI + Math.E/(double)i;
			double burdenCalc3 = burdenCalc1 = burdenCalc2;
			System.out.println(t.getName() + " count = " + i + " burdenCal = " + burdenCalc3);
		}
	}

}
