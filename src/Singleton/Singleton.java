package Singleton;

public class Singleton {

	/*私有构造方法，防止被实例化*/
	private Singleton() {

	}
	
	/**
	 *使用内部类维护单例，JVM内部的机制能够保证当一个类被加载的时候，
	 *这个类的加载过程是线程互斥的。 
	 */
	private static class SingletonFactory{
		private static Singleton instance = new Singleton();
	}
	
	/* 获取实例 */ 
	public static Singleton getInstance(){
		return SingletonFactory.instance;
	}
	
	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
	public Object readResolve(){
		return getInstance();
	}
}
