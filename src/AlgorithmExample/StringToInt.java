package AlgorithmExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将字符串转成整型 1、判断正负 2、去掉字符串中不能转化成整型的因素（包括各种符号、小数点、字母、空格） 3、去掉第一个数字前的所有0
 * 4、结果是否超出整型范围（-2^31~2^31-1）
 * 
 * @author Arnold
 * 
 */
public class StringToInt {
	static int flag = 1;
	static String count ="";
	static int value = 0;

	// 去除所有非数字字符
	public static String judgeString(String oldStr) {
		String regEx = "[^0-9]";// 匹配所有非数字
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(oldStr);
		String newStr = m.replaceAll("");// 将非数字去除
		return newStr;
	}

	// 判断正负
	public static int judgeFirst(String oldStr) {
		String s = oldStr.substring(0, 1);
		if ("-".equals(s))
			return -1;
		else
			return 1;
	}

	// 去除开始0
	public static String getRidZero(String oldStr) {
		return oldStr.replaceAll("^(0+)", "");
	}
	
	//将处理好的String变成int
	public static int stringToInt(String count){
		char[] c = count.toCharArray();
		double value = 0;
		for(int i = 0; i < c.length; i++){
			value = value * 10 + (c[i] - '0');
		}
		double tmp = value * flag;
		if(tmp <= Integer.MAX_VALUE && tmp >= Integer.MIN_VALUE)
			return (int)tmp;
		else 
			return 0;
	}
	
	public static void main(String[] args){
		String s = "-07sadff65-=.,,,/,0849"; 
		
		flag = judgeFirst(s);
		
		count = judgeString(s);
		
		count = getRidZero(count);
		
		value = stringToInt(count);
		
		if (value != 0) {  
            System.out.println(value);  
        } else {  
            System.out.println("value out of range of int!");  
        }
	}
}
