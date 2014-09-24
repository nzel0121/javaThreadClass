package latch;

import java.util.concurrent.CountDownLatch;

public class GoStopPlayerMain {
	private final static int playCount = 3;
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(playCount);
		
		//�÷��̾� ���ҽ� �غ�
		for (int i = 0; i < playCount; i++) {
			Thread t1 = new Thread(new GoStopPlayerResource(countDownLatch));
			t1.start();
		}
		//�÷��̾� ���ҽ��� ��� �ε�ɶ����� ���
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Loaded All Resource Start Game");
	}

}
