package Builder;

public class BuilderTest {
	public static void main(String[] args){
		Builder builder = new ConcreteBuilder();
		Director director = new Director(builder);
		
		director.construct();
		Product product = builder.getProduct();
	}
	
}
