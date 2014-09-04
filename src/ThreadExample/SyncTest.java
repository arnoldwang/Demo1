package ThreadExample;

public class SyncTest {

	public static void main(String[] args){
		Foo f1 = new Foo(1);
		f1.start();
		Foo f2 = new Foo(2);
		f2.start();
	}
}
