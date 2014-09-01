package AbstractFactory;

public class FactoryTest {

	public static void main(String[] args){
		AbstractFactory factory = new MailAndActionFactory();
		factory.createSender().send();
		factory.createVideo().play();
	}
}
