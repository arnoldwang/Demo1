package Command;

public class BackCommand implements Command {

	private AudioPlayer audioPlayer;
	
	public BackCommand(AudioPlayer audioPlayer) {
		super();
		this.audioPlayer = audioPlayer;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		audioPlayer.back();
	}

}
