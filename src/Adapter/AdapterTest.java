package Adapter;

public class AdapterTest {

	public static void main(String[] args){
		Target target = new Adapter();
		target.method1();
		target.method2();
		Source source = new Source();
		Target wrapper = new Wrapper(source);
		wrapper.method1();
		wrapper.method2();
	}
}
