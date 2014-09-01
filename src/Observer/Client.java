package Observer;

import java.util.Observer;

public class Client {

	public static void main(String[] args){
		//创建被观察者
		Watched watched = new Watched();
		//创建观察者，并注册
		Observer watcher = new Watcher(watched);
		
		watched.setData("start");
		watched.setData("run");
		watched.setData("stop");
	}
}
