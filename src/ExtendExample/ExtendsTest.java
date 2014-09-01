package ExtendExample;

public class ExtendsTest extends B{
	public ExtendsTest(int n) {
		super(n);
		System.out.println("ExtendsTest()!");
	}

	public static void main(String[] args) {
		new ExtendsTest(1);
	}
}
