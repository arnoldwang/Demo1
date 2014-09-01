package Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		String s = "abcde";
		Collection c = new MyCollection(new ArrayList(Arrays.asList(s
				.toCharArray())).toArray());
		Iterator itr = c.iterator();
		System.out.println(itr.first());
		System.out.println(itr.next());
		System.out.println(itr.previous());
	}
}
