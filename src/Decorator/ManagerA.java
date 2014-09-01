package Decorator;

public class ManagerA extends Manager {

	private Person person;
	
	public ManagerA(Person p){
		person = p;
	}
	
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		doEarlyWork();
		person.doSomething();
	}

	private void doEarlyWork() {
		// TODO Auto-generated method stub
		System.out.println("research");
	}

}
