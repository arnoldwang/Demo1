package AlgorithmExample;

public class MaxSubSum {

	public static int maxSubSum1(int[] a) {
		int maxSub = 0, thisSub = 0;

		for (int i = 0; i < a.length; i++) {
			thisSub += a[i];
			if (thisSub > maxSub)
				maxSub = thisSub;
			else if (thisSub < 0)
				thisSub = 0;
		}
		return maxSub;
	}

	public static int maxSubSum2(int[] a) {
		return maxSubRec(a, 0, a.length-1);
	}

	private static int maxSubRec(int[] a, int left, int right) {
		// TODO Auto-generated method stub
		if (left == right)
			if (a[left] > 0)
				return a[left];
			else
				return 0;

		int center = (left + right) / 2;
		int maxLeftSum = maxSubRec(a, left, center);
		int maxRightSum = maxSubRec(a, center + 1, right);

		int maxLeftBorderSum = 0, thisLeftBorderSum = 0;
		for (int i = center; i >= left; i--) {
			thisLeftBorderSum += a[i];
			if (thisLeftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = thisLeftBorderSum;
		}

		int maxRightBorderSum = 0, thisRightBorderSum = 0;
		for (int j = center + 1; j <= right; j++) {
			thisRightBorderSum += a[j];
			if (thisRightBorderSum > maxRightBorderSum)
				maxRightBorderSum = thisRightBorderSum;
		}

		return max(maxLeftSum, maxLeftBorderSum + maxRightBorderSum,
				maxRightSum);
	}

	private static int max(int a, int b, int c) {
//		System.out.println("a = " + a);
//		System.out.println("b = " + b);
//		System.out.println("c = " + c);
		// TODO Auto-generated method stub
		if (a > b)
			if (a > c)
				return a;
			else
				return c;
		else if (b > c)
			return b;
		else
			return c;
	}
}
