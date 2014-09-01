package Prototype;

public class PrototypeTest {

	public static void main(String[] args) {
		Cubic cubic = new Cubic(12, 20, 66);
		System.out.println("cubic的长、宽和高：");
		System.out.println(cubic.length + "," + cubic.width + ","
				+ cubic.height);
		try {
			Cubic cubicopy = (Cubic) cubic.cloneme();
			System.out.println("cubicopy的长、宽和高：");
			System.out.println(cubicopy.length + "," + cubicopy.width + ","
					+ cubicopy.height);
		} catch (Exception e) {

		}

		Goat goat = new Goat();
		goat.setColor(new StringBuffer("白色的山羊"));
		System.out.println("goat 是" + goat.getColor());
		try {
			Goat goatCopy = (Goat) goat.cloneme();
			System.out.println("goatCopy是" + goatCopy.getColor());
			System.out.println("goatCopy将自己的颜色改变成黑色");
			goatCopy.setColor(new StringBuffer("黑色的山羊"));
			System.out.println("goat仍然是" + goat.getColor());
			System.out.println("goatCopy是" + goatCopy.getColor());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
