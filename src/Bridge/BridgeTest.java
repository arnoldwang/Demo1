package Bridge;

public class BridgeTest {
	
	public static void main(String[] args){
		Clothing jacket = new Jacket();
		Clothing trouser = new Trouser();
		
		Person man = new Man();
		Person woman = new Woman();
		man.setClothing(jacket);
		woman.setClothing(trouser);
		
		man.dress();
		woman.dress();
	}
}
