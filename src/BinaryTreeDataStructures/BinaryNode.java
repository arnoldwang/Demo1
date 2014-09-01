package BinaryTreeDataStructures;

class BinaryNode {
	
	BinaryNode(Comparable theElement){
		this(theElement, null, null);
	}
	
	BinaryNode(Comparable theElement, BinaryNode leftChild, BinaryNode rightChild){
		element = theElement;
		left = leftChild;
		right = rightChild;
	}
	
	Comparable element;
	BinaryNode left;
	BinaryNode right;
}
