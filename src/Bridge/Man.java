package Bridge;

public class Man extends Person {
	
	public Man(){
		setType("man");
	}

	@Override
	public void dress() {
		// TODO Auto-generated method stub
		System.out.print(getType()+ " ");
		getClothing().dress();
	}

}
