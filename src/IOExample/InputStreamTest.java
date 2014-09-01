package IOExample;

import java.io.BufferedReader;
import java.io.FileReader;

public class InputStreamTest {

	public static String read(String filename) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String s;
		StringBuffer sb = new StringBuffer();
		while((s = br.readLine()) != null)//readLine()读取一行
			sb.append(s + '\n');
		br.close();
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception{
		System.out.print(read("./src/IOExample/InputStreamTest.java"));
	}
}
