package IOExample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class BasicFileOutput {

	static String filename = "./src/IOExample/basic.out";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"./src/IOExample/BasicFileOutput.java"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				filename)));
		int lineCount = 1;
		String s;
		while ((s = br.readLine()) != null) {
			pw.println(lineCount++ + ": " + s);
		}
		pw.close();
		System.out.println(InputStreamTest.read(filename));
	}
}
