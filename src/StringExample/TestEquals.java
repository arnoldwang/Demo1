package StringExample;

public class TestEquals {
	String s1 = new String("abc");//new 会在堆上新开辟内存存放对象
	String s2 = new String("abc");
	String s3 = "abc";//在编译时将“abc”存入字符串常量池，再有新建“abc”直接从中取
	String s4 = "abc";
	String s5 = "a" + "bc";
	String s6 = "a";
	String s7 = s6 + "bc";
	StringBuffer sb = new StringBuffer();
	
	public void test(){
		/**
		 * String类重写了equals()方法，字符串对象的内容或者内存地址有一个相同
		 * 就是相等，以下比较equals()方法都返回true。
		 */
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s3 == s4);
		System.out.println(s3 == s5);
		System.out.println(s3 == s7);
	}
	public static void main(String[] args){
		TestEquals t = new TestEquals();
		t.test();
	}
}
