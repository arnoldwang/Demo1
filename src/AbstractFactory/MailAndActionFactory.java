package AbstractFactory;

public class MailAndActionFactory implements AbstractFactory {

	@Override
	public Sender createSender() {
		// TODO Auto-generated method stub
		return new MailSender();
	}

	@Override
	public Video createVideo() {
		// TODO Auto-generated method stub
		return new actionVideo();
	}

}
