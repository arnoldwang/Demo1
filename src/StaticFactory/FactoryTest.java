package StaticFactory;

public class FactoryTest {
	
	public static void main(String[] args){
		Sender sender = SenderFactory.produceMail();
		sender.send();
	}
}
