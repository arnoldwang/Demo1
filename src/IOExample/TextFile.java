package IOExample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFile extends ArrayList<String> {

	// Read a file, return a String
	public static String read(String filename) {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					filename).getAbsoluteFile()));
			String s;
			try {
				while ((s = br.readLine()) != null) {
					sb.append(s + "\n");
				}
			} finally {
				br.close();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
		return sb.toString();
	}

	// write a single file in a method call
	public static void write(String filename, String text) {
		try {
			PrintWriter pw = new PrintWriter(
					new File(filename).getAbsoluteFile());
			try {
				pw.print(text);
			} finally {
				pw.close();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	public TextFile(String filename, String splitter) {
		super(Arrays.asList(read(filename).split(splitter)));
		if (get(0).equals(""))
			remove(0);
	}

	public TextFile(String filename) {
		this(filename, "\n");
	}

	public void write(String filename) {
		try {
			PrintWriter pw = new PrintWriter(
					new File(filename).getAbsoluteFile());
			try {
				for (String item : this)
					pw.print(item);
			} finally {
				pw.close();
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	public static void main(String[] args) {
		/* read() test */
		System.out.println(read("a.txt"));
		/* write() test */
		write("b.txt", "hello world!\n Arnold");
		/* constractor test */
		TextFile tf = new TextFile("a.txt"); 
		tf.write("c.txt");
	}
}
