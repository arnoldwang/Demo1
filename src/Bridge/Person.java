package Bridge;

public abstract class Person {
	private String type;
	private Clothing clothing;
	
	public abstract void dress();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Clothing getClothing() {
		return clothing;
	}

	public void setClothing(Clothing clothing) {
		this.clothing = clothing;
	}
}
