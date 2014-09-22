package runnableHello;

public class RunnableHelloWorldMain {
	public static void main(String[] args) {
		int count = 5;
		Thread helloworldThread = new Thread(new RunnableHelloWorld(count));
		helloworldThread.start();
	}
}
