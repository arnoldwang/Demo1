package Command;

public class StopCommand implements Command {

	private AudioPlayer audioPlayer;
	
	public StopCommand(AudioPlayer audioPlayer) {
		super();
		this.audioPlayer = audioPlayer;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		audioPlayer.stop();
	}

}
