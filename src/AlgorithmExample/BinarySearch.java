package AlgorithmExample;

public class BinarySearch {

	public static Comparable binarySearch(Comparable[] a, Comparable x){
		int low = 0, high = a.length -1;
		while(low <= high){
			int middle = (low + high)/2;
			if(a[middle].compareTo(x)<0)
				low = middle +1;
			else if(a[middle].compareTo(x)>0)
				high = middle -1;
			else
				return middle;
		}
		return -1;
	}
}
