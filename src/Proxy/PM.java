package Proxy;

public class PM implements Person {
	
	private Person person;
	
	public PM(){
		this.person = new QA();
	}
	
	public PM(Person p){
		this.person = p;
	}
	
	@Override
	public void coding() {
		// TODO Auto-generated method stub
		person.coding();
	}

	@Override
	public void design() {
		// TODO Auto-generated method stub
		person.design();
	}

}
