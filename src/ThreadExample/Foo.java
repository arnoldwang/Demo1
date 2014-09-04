package ThreadExample;

public class Foo extends Thread {

	private int val;
	private static byte[] lock = new byte[0];

	public Foo(int v) {
		val = v;
	}

	public synchronized void printVal1(int v) {
		while (true)
			System.out.println(v);
	}
	
	public void printVal2(int v){
		synchronized (Foo.class) {
			while(true)
				System.out.println(v);
		}
	}
	
	public void printVal3(int v){
		synchronized (lock) {
			while(true)
				System.out.println(v);
		}
	}

	public void printVal4(int v){
		synchronized (this) {
			while(true)
				System.out.println(v);
		}
	}
	public void run() {

		printVal4(val);
	}
}
