package Bridge;

public class Woman extends Person {

	public Woman(){
		setType("woman");
	}
	@Override
	public void dress() {
		// TODO Auto-generated method stub
		System.out.print(getType()+" ");
		getClothing().dress();
	}

}
