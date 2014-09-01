package Command;

public class Client {

	public static void main(String[] args){
		//创建接受者
		AudioPlayer audioPlayer = new AudioPlayer();
		//创建命令
		Command playCommand = new PlayCommand(audioPlayer);
		Command stopCommand = new StopCommand(audioPlayer);
		Command backCommand = new BackCommand(audioPlayer);
		//创建命令发出者
		KeyBoard keyBoard = new KeyBoard();
		keyBoard.setPlayCommand(playCommand);
		keyBoard.setStopCommand(stopCommand);
		keyBoard.setBackCommand(backCommand);
		
		keyBoard.play();
		keyBoard.stop();
		keyBoard.back();
	}
}
