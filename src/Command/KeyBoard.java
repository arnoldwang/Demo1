package Command;

/**
 * 命令发出者
 * 
 * @author Arnold
 * 
 */
public class KeyBoard {

	private Command PlayCommand;
	private Command StopCommand;
	private Command BackCommand;
	
	public void play(){
		PlayCommand.execute();
	}
	
	public void stop(){
		StopCommand.execute();
	}
	
	public void back(){
		BackCommand.execute();
	}
	
	public Command getPlayCommand() {
		return PlayCommand;
	}
	public void setPlayCommand(Command playCommand) {
		PlayCommand = playCommand;
	}
	public Command getStopCommand() {
		return StopCommand;
	}
	public void setStopCommand(Command stopCommand) {
		StopCommand = stopCommand;
	}
	public Command getBackCommand() {
		return BackCommand;
	}
	public void setBackCommand(Command backCommand) {
		BackCommand = backCommand;
	}
}
