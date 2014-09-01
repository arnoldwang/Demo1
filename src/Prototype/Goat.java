package Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Goat implements Prototype, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringBuffer color;

	/**
	 * 深复制
	 */
	@Override
	public Object cloneme() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Object object = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this);// 将原型吸入对象流

			ByteArrayInputStream bis = new ByteArrayInputStream(
					bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			object = ois.readObject();// 创建新对象，复制对象
		} catch (Exception e) {
			System.out.println(e);
		}
		return object;
	}

	public void setColor(StringBuffer color) {
		this.color = color;
	}

	public StringBuffer getColor() {
		return color;
	}

}
