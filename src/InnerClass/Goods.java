package InnerClass;

public class Goods {
	private int valueRate = 3;
	private class Content implements Contents {
		private int valueRate = 11 * Goods.this.valueRate;
		public int value() {
			return valueRate;
		}
	}
	protected class GDestination implements Destination {
		private String label;
		private GDestination(String whereTo) {
			label = whereTo;
		}
		public String readLabel() {
			return label;
		}
	}
	public Destination dest(String s) {
		return new GDestination(s);
	}
	public Contents cont() {
		return new Content();
	}
	
	public static void main(String[] args){
		Goods g = new Goods();
		Contents c = g.cont();
		Goods.GDestination d = g.new GDestination("beijing"); 
		System.out.println(c.value());
	}
}

  
 