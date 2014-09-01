package Decorator;

public class DecoratorTest {

	public static void main(String[] args){
		Person p = new Coder();
		ManagerA ma = new ManagerA(p);
		ManagerB mb = new ManagerB(p);
		ma.doSomething();
		mb.doSomething();
	}
}
