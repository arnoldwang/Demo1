package Dynamic;

public class CoinProblem {

	/**
	 * 
	 * 硬币找零：动态规划算法
	 * 
	 * @param values
	 *            :保存每一种硬币的币值的数组
	 * 
	 * @param valueKinds
	 *            :币值不同的硬币种类数量，即coinValue[]数组的大小
	 * 
	 * @param money
	 *            :需要找零的面值
	 * 
	 * @param coinsUsed
	 *            :保存面值为i的纸币找零所需的最小硬币数
	 */

	public static int makeChange(int[] values, int money) {
		int valueKinds = values.length;

		int[] v = new int[money + 1];

		//钱数等于当前面值时，结果赋值为1
		for (int i = 0; i < valueKinds; i++) {
			if(values[i] <= money)
				v[values[i]] = 1;
		}

		for (int cents = 1; cents <= money; cents++) {
			for (int kind = 0; kind < valueKinds; kind++) {
				if (cents > values[kind]) {// 钱数大于当前面值时（等于已经处理过，小于不够找，跳过）
					if (v[cents] == 0 && v[cents - values[kind]] != 0)
						v[cents] = v[cents - values[kind]] + 1;
					else if (v[cents - values[kind]] != 0)// 等于0时，说明子集也不满足
						v[cents] = v[cents - values[kind]] + 1 < v[cents] ? v[cents - values[kind]] + 1 : v[cents];
				}
			}
		}
		if (v[money] == 0)
			return -1;
		else
			return v[money];
	}

	public static void main(String[] args) {

		int[] coinValue = { 10, 21, 17, 3 };
		int money = 18;
		
		System.out.print(CoinProblem.makeChange(coinValue, money));
		
	}
}
