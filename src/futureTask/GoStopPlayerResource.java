package futureTask;

import java.util.concurrent.Callable;

public class GoStopPlayerResource implements Callable<GoStopPlayer> {

	@Override
	public GoStopPlayer call() throws Exception {
		GoStopPlayer player = new GoStopPlayer();
		player.setName(Thread.currentThread().getName());
		return player;
	}

}
