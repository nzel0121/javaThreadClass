package threadSafe;

import java.math.BigInteger;

public class ThreadSafeController {
	public String service(Object request) {

		// 파라메터 분석
		BigInteger intParam = extractParamFromRequest(request);

		// 파라미터 가지고 서비스 호출(비즈니스로직처리)
		BigInteger result = processParam(intParam);

		// 결과저장
		Context.local.set(result);

		// 수행종료
		return "Success";
	}

	private BigInteger extractParamFromRequest(Object request) {
		return BigInteger.valueOf(7L);
	}

	private BigInteger processParam(BigInteger intParam) {
		return BigInteger.valueOf(1L);
	}
}
