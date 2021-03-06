package BinaryTree;

public class BinarySearchTree {

	private BinaryNode root;

	public BinarySearchTree() {
		root = null;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	private Comparable elementAt(BinaryNode t) {
		return t == null ? null : t.element;
	}

	private BinaryNode find(Comparable x, BinaryNode t) {
		if (t == null)
			return null;
		if (x.compareTo(t.element) < 0) {
			return find(x, t.left);
		} else if (x.compareTo(t.element) > 0) {
			return find(x, t.right);
		} else
			return t;
	}

	private BinaryNode findMin(BinaryNode t) {
		if (t != null)
			while (t.left != null)
				t = t.left;
		return t;
	}

	private BinaryNode findMax(BinaryNode t) {
		if (t == null || t.right == null)
			return t;
		return findMax(t.right);
	}

	private BinaryNode insert(Comparable x, BinaryNode t) {
		if (t == null)
			t = new BinaryNode(x, null, null);
		else if (x.compareTo(t.element) < 0)
			t.left = insert(x, t.left);
		else if (x.compareTo(t.element) > 0)
			t.right = insert(x, t.right);
		else
			;
		return t;
	}

	private BinaryNode remove(Comparable x, BinaryNode t) {
		if (t == null)
			return t;
		if (x.compareTo(t.element) < 0)
			t.left = remove(x, t.left);
		else if (x.compareTo(t.element) > 0)
			t.right = remove(x, t.right);
		else if (t.left != null && t.right != null) {//two children
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		} else
			t = (t.left != null) ? t.left : t.right;
		return t;
	}
	
	public Comparable findMin(){
		return elementAt(findMin(root));
	}
	
	public Comparable findMax(){
		return elementAt(findMax(root));
	}
	
	public void insert(Comparable x){
		root = insert(x, root);
	}
	
	public void remove(Comparable x){
		root = remove(x, root);
	}
	
	public void printTree(){
		if(isEmpty())
			System.out.print("Empty tree");
		else
			printTree(root);
	}

	private void printTree(BinaryNode t) {
		// TODO Auto-generated method stub
		if(t != null){
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
}
