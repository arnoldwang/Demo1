package AlgorithmExample;

public class Sort {

	public static void insertSort(Comparable[] a) {
		int i;
		for (int p = 1; p < a.length; p++) {
			Comparable tmp = a[p];
			if (tmp.compareTo(a[p - 1]) < 0) {// 剪枝
				for (i = p; i > 0 && tmp.compareTo(a[i - 1]) < 0; i--)
					a[i] = a[i - 1];
				a[i] = tmp;
			}
		}
		// for (Comparable item : a)
		// System.out.print(item + " ");
	}

	public static void shellSort(Comparable[] a) {
		int i;
		// while (Math.pow(2, i + 1) < a.length) {//这部分耗时大
		// i++;
		// }

		int[] shell = { 1, 3, 7 };
		// for (int j = 0; j < i; j++)
		// shell[j] = (int) Math.pow(2, j + 1) - 1;

		int gap;
		for (i = shell.length - 1; i >= 0; i--) {
			gap = shell[i];
			for (int k = gap; k < a.length; k++) {
				Comparable tmp = a[k];
				if (a[k].compareTo(a[k - gap]) < 0) {
					int p = k;
					for (; p >= gap && tmp.compareTo(a[p - gap]) < 0; p -= gap)
						a[p] = a[p - gap];
					a[p] = tmp;
				}
			}
		}
		// for (Comparable item : a)
		// System.out.print(item + " ");
	}

	public static void shellSort1(Comparable[] a) {
		for (int gap = a.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < a.length; i++) {
				Comparable tmp = a[i];
				int j = i;

				for (; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
					a[j] = a[j - gap];
				a[j] = tmp;
			}
		}
		// for (Comparable item : a)
		// System.out.print(item + " ");
	}

	private static void percolateDown(Comparable[] a, int i, int n) {
		int child;
		Comparable tmp = a[i];

		for (; i * 2 < n; i = child) {
			child = i * 2;
			if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0)
				child++;
			if (tmp.compareTo(a[child]) < 0)
				a[i] = a[child];
			else
				break;
		}
		a[i] = tmp;
	}

	public static void heapSort(Comparable[] a) {
		for (int i = a.length / 2; i >= 0; i--)
			percolateDown(a, i, a.length);

		for (int i = a.length - 1; i > 0; i--) {
			swapReference(a, 0, i);
			percolateDown(a, 0, i);
		}

		// for (Comparable item : a)
		// System.out.print(item + " ");
	}

	private final static void swapReference(Comparable[] a, int begin, int end) {
		// TODO Auto-generated method stub
		Comparable tmp = a[begin];
		a[begin] = a[end];
		a[end] = tmp;
	}

	private static void mergeSort(Comparable[] a, Comparable[] tmpArray,
			int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(a, tmpArray, left, center);
			mergeSort(a, tmpArray, center + 1, right);
			merge(a, tmpArray, left, center, right);
		}
	}

	private static void merge(Comparable[] a, Comparable[] tmpArray,
			int leftPos, int rightPos, int rightEnd) {
		// TODO Auto-generated method stub
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		while (leftPos <= leftEnd && rightPos <= rightEnd)
			if (a[leftPos].compareTo(a[rightPos]) <= 0)
				tmpArray[tmpPos++] = a[leftPos++];
			else
				tmpArray[tmpPos++] = a[rightPos++];

		while (leftPos <= leftEnd)
			tmpArray[tmpPos++] = a[leftPos++];

		while (rightPos <= rightEnd)
			tmpArray[tmpPos++] = a[rightPos++];

		for (int i = 0; i < numElements; i++, rightEnd--)
			a[rightEnd] = tmpArray[rightEnd];
	}

	public static void mergeSort(Comparable[] a) {
		Comparable[] tmpArray = new Comparable[a.length];

		mergeSort(a, tmpArray, 0, a.length - 1);
	}

	private static Comparable median3(Comparable[] a, int left, int right) {
		int center = (left + right) / 2;
		if (a[center].compareTo(a[left]) < 0)
			swapReference(a, left, center);
		if (a[right].compareTo(a[center]) < 0)
			swapReference(a, center, right);
		if (a[center].compareTo(a[left]) < 0)
			swapReference(a, left, center);

		swapReference(a, center, right - 1);
		return a[right - 1];
	}

	private static void quickSort(Comparable[] a, int left, int right) {
		Comparable pivot = median3(a, left, right);
		
		int i = left, j = right -1;
		while(true){
			while(a[++i].compareTo(pivot)<0){}
			while(a[--j].compareTo(pivot)>0){}
			
			if(i<j)
				swapReference(a, i, j);
			else
				break;
		}
		swapReference(a, i, right-1);
		
		quickSort(a, left, i-1);
		quickSort(a, i+1,right);
		
	}
}
