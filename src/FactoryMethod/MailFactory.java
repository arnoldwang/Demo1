package FactoryMethod;

public class MailFactory implements SenderFactory {

	@Override
	public Sender create() {
		// TODO Auto-generated method stub
		return new MailSender();
	}

}
