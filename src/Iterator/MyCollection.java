package Iterator;

public class MyCollection extends Collection {
	private Object[] value;
	private int count;
	
	public MyCollection(Object[] value){
		this.value = value;
		count = value.length;
	}
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new MyIterator(this);
	}

	@Override
	public Object get(int i) {
		// TODO Auto-generated method stub
		return value[i];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

}
