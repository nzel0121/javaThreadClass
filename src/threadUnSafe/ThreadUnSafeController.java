package threadUnSafe;

import java.math.BigInteger;


public class ThreadUnSafeController {
	private long requestCount = 9000000000000000000L;
	private Object a= new Object();
	public synchronized String service(Object request){
		synchronized(a){
			requestCount++;
		}
		// 파라메터 분석
		BigInteger intParam = extractParamFromRequest(request);

		// 파라미터 가지고 서비스 호출(비즈니스로직처리)
		BigInteger result = processParam(intParam);

		// 결과저장
		//Context.local.set(result);

		// 수행종료
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
