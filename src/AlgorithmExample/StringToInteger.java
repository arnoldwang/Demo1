package AlgorithmExample;

public class StringToInteger {
	
	//将16进制字符串转成int
	public static int hexStrToInt(String str){
		int result = 0;
		int len = str.length()-1;
		
		for(int i = len; i>=0; i--){
			char c = str.charAt(i);
			result += Character.digit(c, 16)*(1<<(4*(len-i)));
		}
		return result;
	}
}
