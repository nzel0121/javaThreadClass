package joinExample;

public class JoinExampleMain {

	public static void main(String[] args) {
		ResourceLoader resourceLoader = new ResourceLoader();
		Thread calculateThread = new Thread(new Calculator(resourceLoader));
		calculateThread.start();
	}

}
