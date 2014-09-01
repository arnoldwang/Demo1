package RedBlackTree;

public class RedBlackNode {

	public static final byte RED = 0x00;
	public static final byte BLACK = 0x01;
	public static RedBlackNode NILL = new RedBlackNode(BLACK);
	
	RedBlackNode parent;
	RedBlackNode left;
	RedBlackNode right;
	Comparable element;
	byte color;
	
	public  RedBlackNode(RedBlackNode parent, RedBlackNode left,
			RedBlackNode right) {
		super();
		this.parent = parent;
		this.left = left;
		this.right = right;
		color = RED;
	}
	
	public RedBlackNode(byte color){	
		this.color = color;
	}
	
	public RedBlackNode(Comparable element){
		this.element = element;
		this.color = RED;
		
	}
	
	protected RedBlackNode(RedBlackNode parent, RedBlackNode left,
			RedBlackNode right, Comparable element, byte color) {
		super();
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.element = element;
		this.color = color;
	}

	public RedBlackNode(Comparable element, byte color){
		this.element = element;
		this.color = color;
		this.left = NILL;
		this.right = NILL;
	}
}
