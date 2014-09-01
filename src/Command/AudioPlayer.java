package Command;

/**
 * 命令执行者
 * 
 * @author Arnold
 * 
 */
public class AudioPlayer {

	public void play(){
		System.out.println("播放...");
	}
	
	public void stop(){
		System.out.println("停止...");
	}
	
	public void back(){
		System.out.println("倒带...");
	}
}
