package AbstractFactory;

public class SmsAndCartonFactory implements AbstractFactory {

	@Override
	public Sender createSender() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

	@Override
	public Video createVideo() {
		// TODO Auto-generated method stub
		return new cartonVideo();
	}

}
