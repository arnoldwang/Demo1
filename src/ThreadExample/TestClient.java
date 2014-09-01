package ThreadExample;

public class TestClient implements Runnable {

	private SequenceNumber sn;

	public TestClient(SequenceNumber sn) {
		this.sn = sn;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			System.out.println("thread[" + Thread.currentThread().getName()
					+ "] - sn[" + sn.getNextNum() + "]");
		}
	}

}
