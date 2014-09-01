package AlgorithmExample;

import java.util.Iterator;
import java.util.Set;

public class ArrangementString {

	// 求一个字符串某个区间上的全排列（去重），begin为起始点，end为结束点
	public static void permutationSolution(String s, int begin, int end) {
		if (begin == end - 1) {
			for (int i = 0; i < end; i++) {
				System.out.print(s.charAt(i));
			}
			System.out.print("\n");
		} else {
			for (int k = begin; k < end; k++) {
				char[] c = s.toCharArray();
				if (isSwap(c, k, begin)) {
					c = swap(c, k, begin);
					permutationSolution(new String(c), begin + 1, end);
					c = swap(c, k, begin);
					s = new String(c);
				}
			}
		}
	}

	// 从一个字符串中选m个字符组合
	public static void combination_m(String s, int m, Set<Character> result) {
		if (s == null ||( s.equals("") && m != 0))
			return;
		if (m == 0) {
			Iterator it = result.iterator();
			while (it.hasNext()) {
				System.out.print(it.next());
			}
			System.out.print("\n");
			return;
		}

		result.add(s.charAt(0));
		String new_s = s.substring(1);
		combination_m(new_s, m - 1, result);
		result.remove(s.charAt(0));
		combination_m(new_s, m, result);

	}
	
	//	一个字符串的全组合
	public static void combination(String s) {
		int n = s.length();
		for (int i = 0; i < (1 << n); i++) {
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					System.out.print(s.charAt(j));
				}
			}
			System.out.println();
		}
	}

	private static char[] swap(char[] c, int k, int begin) {
		// TODO Auto-generated method stub
		char temp = c[k];
		c[k] = c[begin];
		c[begin] = temp;
		return c;
	}

	private static boolean isSwap(char[] c, int k, int begin) {
		boolean flag = true;
		for (int i = begin; i < k; i++) {
			if (c[i] == c[k]) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
