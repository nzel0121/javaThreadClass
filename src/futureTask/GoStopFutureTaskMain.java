package futureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class GoStopFutureTaskMain {
	private static final FutureTask<GoStopPlayer> player1 = new FutureTask<GoStopPlayer>(new GoStopPlayerResource());
	private static final FutureTask<GoStopPlayer> player2 = new FutureTask<GoStopPlayer>(new GoStopPlayerResource());
	private static final FutureTask<GoStopPlayer> player3 = new FutureTask<GoStopPlayer>(new GoStopPlayerResource());
	public static void main(String[] args) {
		try {
			new Thread(player1).start();
			System.out.println("player1's name = " + player1.get().getName());
			new Thread(player2).start();
			System.out.println("player1's name = " + player2.get().getName());
			new Thread(player3).start();
			System.out.println("player1's name = " + player3.get().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("if Loaded All Resource then Start Game!");
	}

}
