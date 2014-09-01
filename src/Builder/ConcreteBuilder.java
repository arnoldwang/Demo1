package Builder;

public class ConcreteBuilder implements Builder {

	@Override
	public void BuildPartA() {
		// TODO Auto-generated method stub
		System.out.println("build part A!");
	}

	@Override
	public void BuildPartB() {
		// TODO Auto-generated method stub
		System.out.println("build part B!");
	}

	@Override
	public void BuildPartC() {
		// TODO Auto-generated method stub
		System.out.println("build part C!");
	}

	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		System.out.println("build finish!");
		return null;
	}

}
