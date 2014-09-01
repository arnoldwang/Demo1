package IOExample;

import java.io.StringReader;

public class MemoryInput {

	public static void main(String[] args) throws Exception {
		StringReader in = new StringReader(
				InputStreamTest.read("./src/IOExample/MemoryInput.java"));

		int c;
		while ((c = in.read()) != -1)//read()读取一个字符并返回ascii值
			System.out.print((char) c);
	}
}
