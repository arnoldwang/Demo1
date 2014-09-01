package Adapter;

public class Wrapper implements Target {

	private Source source;
	
	public Wrapper(Source source){
		this.source = source;
	}
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		source.method1();
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("This is a target method!");
	}

}
