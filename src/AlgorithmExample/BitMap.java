package AlgorithmExample;

public class BitMap {

	final int BITSPERWORD = 32;
	final int SHIFT = 5;
	final int MASK  = 0x1F;
	final int N = 100000000;
	
	int[] a = new int[1 + N/BITSPERWORD];
	
	//set 设置所在的bit位为1 
	public void set(int i){
		a[i >> SHIFT] |= (1 << (i & MASK));
	}
	
	//clr 设置所在的bit位为0
	public void clr(int i){
		a[i >> SHIFT] &= ~(1 << (i & MASK));
	}
	
	public int test(int i){
		return a[i >> SHIFT] & (1 << (i & MASK));
	}
}
