package AvlTreeDataStructures;

class AvlNode {
	
	Comparable element;
	AvlNode left;
	AvlNode right;
	int height;
	
	AvlNode(Comparable theElement){
		this(theElement, null, null);
	}

	AvlNode(Comparable theElement, AvlNode lt, AvlNode rt) {
		// TODO Auto-generated constructor stub
		element = theElement;
		left = lt;
		right = rt;
	}
}
