package Prototype;

public class Cubic implements Prototype, Cloneable {
	double length, width, height;
	
	public Cubic(double l, double w, double h){
		length = l;
		width = w;
		height = h;
	}
	/**
	 * 浅复制
	 */
	@Override
	public Object cloneme() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Cubic cubic = (Cubic)super.clone();
		return cubic;
	}

}
