package StaticFactory;

public class SenderFactory {

	public static Sender produceMail() {
		return new MailSender();
	}
	
	public static Sender produceSms(){
		return new SmsSender();
	}
}
