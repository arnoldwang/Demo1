package AlgorithmExample;

import java.util.ArrayList;

public class ShootProblem {
	/**
	 * n枪打m环问题
	 */
	public static int totals = 0;

	public static void shootProblemSolution(int number, int sum,
			ArrayList<Integer> result) {
		if (sum < 0 || number * 10 < sum)// number*10 < sum用来剪枝
			return;
		if (number == 1) {
			for (int i : result)
				System.out.print(i + " ");
			System.out.print(sum + "\n");
			totals++;
			return;
		}
		for (int i = 0; i <= 10; i++) {
			result.add(i);
			shootProblemSolution(number - 1, sum - i, result);
			result.remove(result.size() - 1);
		}
	}

	/**
	 * 变种：输入两个整数n和m，从数列1,2,3...n中随意取几个数，使其和等于m，要求列出所有的组合。
	 */
	public static void findFactor(int n, int m, ArrayList<Integer> result) {
		if (m <= 0 || n <= 0)
			return;
		if (m == n) {//输出条件一定位m==n,不能是m==0
			for (int i : result)
				System.out.print(i + " ");
			System.out.println(n);
		}
		result.add(n);
		findFactor(n - 1, m - n, result);
		result.remove(result.size() - 1);
		findFactor(n - 1, m, result);

	}
}
