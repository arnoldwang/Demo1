package Proxy;

public class ProxyTest {
	
	public static void main(String[] args){
		PM pm = new PM();
		pm.design();
		pm.coding();
		UI ui = new UI();
		pm = new PM(ui);
		pm.design();
		pm.coding();
	}
}
