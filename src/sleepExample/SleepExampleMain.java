package sleepExample;

public class SleepExampleMain {

	public static void main(String[] args) {

		int count =5;
		Thread sleepExample = new Thread(new SleepExample(count));
		sleepExample.start();
	}

}
