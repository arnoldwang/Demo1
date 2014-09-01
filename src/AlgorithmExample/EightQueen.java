package AlgorithmExample;

public class EightQueen {
	
/**
 * 由于八个皇后的任意两个不能处在同一行，那么这肯定是每一个皇后占据一行。
 * 于是我们可以定义一个数组Col[8]，数组中第i个数字表示位于第i行的皇后的列号。
 * 先把ColumnIndex的八个数字分别用0-7初始化，接下来我们要做的事情就是对数组ColumnIndex做全排列。
 * 由于我们是用不同的数字初始化数组中的数字，因此任意两个皇后肯定不同列。
 * 我们只需要判断得到的每一个排列对应的八个皇后是不是在同一对角斜线上，
 * 也就是数组的两个下标i和j，是不是i-j==Col[i]-Col[j](主对角线)或者j-i==Col[i]-Col[j](副对角线)。
 */
	public static int totalNumber = 0;
	
	public static void eightQueenSolution(){
		int queens = 8;
		int[] col = new int[queens];
		for(int i = 0; i<queens; i++){
			col[i] = i;
		}
		permutation(col, queens, 0);
	}
//	数值全排列
	private static void permutation(int[] col, int length, int index) {
		// TODO Auto-generated method stub
		if(index == length-1){
			if(check(col, length)){
				totalNumber++;
				for(int i: col)
					System.out.print(i + " ");
				System.out.println();
			}
		}else{
			for(int i = index; i < length; i++){
				col = swap(col, i, index);
				permutation(col, length, index+1);
				col = swap(col, i, index);
			}
		}
		
	}

	private static int[] swap(int[] col, int i, int index) {
		// TODO Auto-generated method stub
		int temp = col[i];
		col[i] = col[index];
		col[index] = temp;
		return col;
	}

//	验证是否符合要求
	private static boolean check(int[] col, int length) {
		// TODO Auto-generated method stub
		boolean flag = true;
		for(int i = 0; i < length; i++){
			for(int j = i+1; j < length; j++){
				if(col[i]-col[j] == i -j||col[j]-col[i] == i-j){
					flag = false;
					return flag;
				}
			}
		}
		return flag;
	}
}
