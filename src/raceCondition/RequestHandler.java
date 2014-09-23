package raceCondition;

public class RequestHandler implements Runnable {

	@Override
	public void run() {

		SingletonCounter singletonCounter = SingletonCounter.getInstance();
		System.out.println("counter = "+ singletonCounter);
	}

}
