package FactoryMethod;

public class FactoryTest {

	public static void main(String[] args){
		SenderFactory mailFactory = new MailFactory();
		Sender sender = mailFactory.create();
		sender.send();
	}
}
