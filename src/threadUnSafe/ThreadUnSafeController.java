package threadUnSafe;

import java.math.BigInteger;


public class ThreadUnSafeController {
	private long requestCount = 9000000000000000000L;
	private Object a= new Object();
	public synchronized String service(Object request){
		synchronized(a){
			requestCount++;
		}
		// �Ķ���� �м�
		BigInteger intParam = extractParamFromRequest(request);

		// �Ķ���� ������ ���� ȣ��(����Ͻ�����ó��)
		BigInteger result = processParam(intParam);

		// �������
		//Context.local.set(result);

		// ��������
		return "Success";
	}
	private BigInteger extractParamFromRequest(Object request) {
		return BigInteger.valueOf(7L);
	}

	private BigInteger processParam(BigInteger intParam) {
		return BigInteger.valueOf(1L);
	}
	public long getRequestCount() {
		return requestCount;
	}
	public void setRequestCount(long requestCount) {
		this.requestCount = requestCount;
	}
	
}
