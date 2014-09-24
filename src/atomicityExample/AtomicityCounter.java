package atomicityExample;

public class AtomicityCounter {
	private long count = 9000000000000L;

	public synchronized void increment(){
		count++;
	}
	
	public long getCount() {
		return count;
	}
	
}
