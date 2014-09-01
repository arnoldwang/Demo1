package Command;

public class PlayCommand implements Command {

	private AudioPlayer audioPlayer;
	
	public PlayCommand(AudioPlayer audioPlayer){
		this.audioPlayer = audioPlayer;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		audioPlayer.play();
	}

}
