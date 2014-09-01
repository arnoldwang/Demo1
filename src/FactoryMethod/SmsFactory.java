package FactoryMethod;

public class SmsFactory implements SenderFactory {

	@Override
	public Sender create() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

}
