package latch;

import java.util.concurrent.CountDownLatch;

public class GoStopPlayerMain {
	private final static int playCount = 3;
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(playCount);
		
		//플레이어 리소스 준비
		for (int i = 0; i < playCount; i++) {
			Thread t1 = new Thread(new GoStopPlayerResource(countDownLatch));
			t1.start();
		}
		//플레이어 리소스가 모두 로드될때까지 대기
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Loaded All Resource Start Game");
	}

}
