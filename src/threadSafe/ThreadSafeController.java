package threadSafe;

import java.math.BigInteger;

public class ThreadSafeController {
	public String service(Object request) {

		// �Ķ���� �м�
		BigInteger intParam = extractParamFromRequest(request);

		// �Ķ���� ������ ���� ȣ��(����Ͻ�����ó��)
		BigInteger result = processParam(intParam);

		// �������
		Context.local.set(result);

		// ��������
		return "Success";
	}

	private BigInteger extractParamFromRequest(Object request) {
		return BigInteger.valueOf(7L);
	}

	private BigInteger processParam(BigInteger intParam) {
		return BigInteger.valueOf(1L);
	}
}
