package AvlTree;

public class AvlTree {
	private AvlNode root;

	public AvlTree() {
		root = null;
	}

	private static int height(AvlNode t) {
		return t == null ? -1 : t.height;
	}
	                                         
	private AvlNode insert(Comparable x, AvlNode t){
		if(t == null)
			t = new AvlNode(x, null, null);
		else if(x.compareTo(t.element) < 0){
			t.left = insert(x, t.left);
			if(height(t.left) - height(t.right) == 2){
				if(x.compareTo(t.left.element) < 0)
					t = rotateWithLeftChild(t);
				else
					t = doubleWithLeftChild(t);
			}
		}else if(x.compareTo(t.element) > 0){
			t.right = insert(x, t.right);
			if(height(t.right) - height(t.left) == 2)
				if(x.compareTo(t.right.element) < 0)
					t = doubleWithRightChild(t);
				else
					t = rotateWithRightChild(t);
		}else
			;//duplicate,do nothing;
		t.height = max(height(t.left), height(t.right)) + 1;
		return t;
	}

	private static AvlNode doubleWithRightChild(AvlNode t) {
		// TODO Auto-generated method stub
		t.right = rotateWithLeftChild(t.right);
		return rotateWithRightChild(t);
	}

	private static AvlNode doubleWithLeftChild(AvlNode t) {
		// TODO Auto-generated method stub
		AvlNode k1 = t.left;
		AvlNode k2 = k1.right;
		k1.right = k2.left;
		t.left = k2.right;
		k2.left = k1;
		k2.right = k1;
		t.height = max(height(t.left), height(t.right)) + 1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		k2.height = max(height(k2.left), height(k2.right)) + 1;
		return k2;
	}

	private static AvlNode rotateWithRightChild(AvlNode t) {
		// TODO Auto-generated method stub
		AvlNode k1 = t.right;
		t.right = k1.left;
		k1.left = t;
		t.height = max(height(t.left), height(t.right)) + 1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		return k1;
	}

	private static AvlNode rotateWithLeftChild(AvlNode t) {
		// TODO Auto-generated method stub
		AvlNode k1 = t.left;
		t.left = k1.right;
		k1.right = t;
		t.height = max(height(t.left) , height(t.right)) + 1;
		k1.height = max(height(k1.left) ,height(k1.right)) + 1;
		return k1;
	}

	private static int max(int a, int b) {
		// TODO Auto-generated method stub
		return a > b ? a : b;
	}
	
	//对外接口
	public void insert(Comparable x){
		root = insert(x, root);
	}
}
