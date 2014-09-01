package BinaryHeapDataStructures;

public class BinaryHeap {
	private static final int DEFAULT_CAPACITY = 100;

	private int currentSize;
	private Comparable[] array;

	public BinaryHeap() {
		this(DEFAULT_CAPACITY);
	}

	public BinaryHeap(int capacity) {
		currentSize = 0;
		array = new Comparable[capacity + 1];
	}

	public void makeEmpty() {
		currentSize = 0;
	}

	public boolean isEmpty() {
		return currentSize == 0 ? true : false;
	}

	public boolean isFull() {
		return currentSize == array.length - 1 ? true : false;
	}

	public void insert(Comparable x) {
		if (isFull()) {
			System.out.println("array is full");
			return;
		}
		int hole = ++currentSize;
		for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2)
			array[hole] = array[hole / 2];
		array[hole] = x;
	}

	public Comparable deleteMin() {
		if (isEmpty()) {
			return null;
		}
		Comparable minItem = array[1];
		array[1] = array[currentSize--];
		percolateDown(1);
		return minItem;
	}

	private void percolateDown(int hole) {
		int child;
		Comparable tmp = array[hole];

		for (; hole * 2 <= currentSize; hole = child) {
			child = hole * 2;
			if (child != currentSize
					&& array[child + 1].compareTo(array[child]) < 0) {
				child++;
			}
			if (array[child].compareTo(tmp) < 0)
				array[hole] = array[child];
			else
				break;
		}
		array[hole] = tmp;
	}

	private void buildHeap() {
		for (int i = currentSize / 2; i > 0; i--) {
			percolateDown(i);
		}
	}
}
