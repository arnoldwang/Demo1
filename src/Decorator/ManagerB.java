package Decorator;

public class ManagerB extends Manager {

	private Person person;
	
	public ManagerB(Person p){
		person = p;
	}
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		person.doSomething();
		doAfterWork();
	}
	private void doAfterWork() {
		// TODO Auto-generated method stub
		System.out.println("review");
	}

}
