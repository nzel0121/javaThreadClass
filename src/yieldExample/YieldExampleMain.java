package yieldExample;

public class YieldExampleMain {

	public static void main(String[] args) {
		int count = 5;
		Thread yieldExample1 = new Thread(new YieldExample(count));
		Thread yieldExample2 = new Thread(new YieldExample(count));
		yieldExample1.start();
		yieldExample2.start();
	}

}
