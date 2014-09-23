package raceCondition;

public class RaceConditionMain {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			Thread rh = new Thread(new RequestHandler());
			rh.start();
		}
	}

}
