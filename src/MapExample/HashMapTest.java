package MapExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapTest {

	/**
	 * 打印数组中出现n/2以上的元素
	 * 
	 * @param a
	 */
	public static void printArray1(Object[] a) {
		Map<Object, Integer> map = new HashMap<Object, Integer>();
		for (Object o : a) {
			if (map.containsKey(o)) {
				map.put(o, map.get(o) + 1);
			} else {
				map.put(o, 1);
			}
		}
		for (Object o : a) {
			if (map.get(o) >= a.length / 2)
				System.out.println(o);
		}
	}

	/**
	 * 按数组中元素出现的次数从小大到打印数组
	 * 
	 * @param a
	 */
	public static void printArray2(Object[] a) {
		Map<Object, Integer> map = new HashMap<Object, Integer>();
		for (Object o : a)
			if (map.containsKey(o))
				map.put(o, map.get(o) + 1);
			else
				map.put(o, 1);

		List<Entry<Object, Integer>> list = new ArrayList<Entry<Object, Integer>>(
				map.entrySet());
		Collections.sort(list, new Comparator<Entry<Object, Integer>>() {
			public int compare(Entry<Object, Integer> e1,
					Entry<Object, Integer> e2) {
				return e1.getValue() - e2.getValue();
			}
		});

		for (Entry<Object, Integer> e : list)
			System.out.println(e);

	}

	public static void main(String[] args) {
		Object[] a = { 2, 5, 2, 3, 5, 2, 3, 5, 2, 3, 5, 2, 3, 5, 2, 7, 8, 8, 7,
				8, 7, 9, 0 };
		HashMapTest.printArray2(a);
	}

}
