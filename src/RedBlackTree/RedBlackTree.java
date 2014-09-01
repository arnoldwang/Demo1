package RedBlackTree;

public class RedBlackTree {

	private RedBlackNode root;

	public RedBlackTree() {
		root = null;
	}

	// 左旋转
	private RedBlackNode leftRotate(RedBlackNode t) {
		if (t == null || t == RedBlackNode.NILL)
			return t;
		RedBlackNode k1 = t.right;
		t.right = k1.left;
		k1.left.parent = t;
		k1.left = t;
		k1.parent = t.parent;
		if (t.parent == RedBlackNode.NILL)
			root = k1;
		else if (t == t.parent.left)
			t.parent.left = k1;
		else
			t.parent.right = k1;
		t.parent = k1;
		return k1;
	}

	// 右旋
	private RedBlackNode rightRotate(RedBlackNode t) {
		if (t == null || t == RedBlackNode.NILL)
			return t;
		RedBlackNode k1 = t.left;
		t.left = k1.right;
		k1.right.parent = t;
		k1.right = t;
		k1.parent = t.parent;
		if (t.parent == RedBlackNode.NILL)
			root = k1;
		else if (t == t.parent.left)
			t.parent.left = k1;
		else
			t.parent.right = k1;
		t.parent = k1;
		return k1;
	}

	public void insert(RedBlackNode node) {
		RedBlackNode preNode = RedBlackNode.NILL;
		RedBlackNode curNode = root;
		while (curNode != RedBlackNode.NILL) {
			preNode = curNode;
			if (node.element.compareTo(curNode.element) < 0)
				curNode = curNode.left;
			else if (node.element.compareTo(curNode.element) > 0)
				curNode = curNode.right;
			else
				return;// if same, do nothing;
		}

		node.parent = preNode;
		if (preNode == RedBlackNode.NILL)
			root = node;
		else if (node.element.compareTo(preNode.element) < 0)
			preNode.left = node;
		else
			preNode.right = node;

		node.left = node.right = RedBlackNode.NILL;
		node.color = RedBlackNode.RED;
		brInsertFixup(node);

	}

	/**
	 * 插入一个红节点后，对树进行修复
	 * 
	 * @param node
	 */
	private void brInsertFixup(RedBlackNode node) {
		// TODO Auto-generated method stub
		RedBlackNode pNode;// 指向叔叔节点
		while (node.parent.color == RedBlackNode.RED) {
			if (node.parent == node.parent.parent.left) {
				pNode = node.parent.parent.right;// 叔叔节点为祖父节点的右儿子
				if (pNode.color == RedBlackNode.RED) {// 叔叔、父亲都为红时，父叔涂黑，祖父涂红，祖父为当前节点
					node.parent.color = RedBlackNode.BLACK;
					pNode.color = RedBlackNode.BLACK;
					node = node.parent.parent;
				} else {
					if (node == node.parent.right) {// 叔叔为黑且当前节点为父节点右儿子时，以父为当前节点左旋
						node = node.parent;
						leftRotate(node);
					} else {// 叔叔为黑且当前节点为父节点左儿子时，父涂黑，祖父涂红，以祖父节点右旋，当前节点不变
						node.parent.color = RedBlackNode.BLACK;
						node.parent.parent.color = RedBlackNode.RED;
						rightRotate(node.parent.parent);
					}
				}
			} else {// 镜像处理
				pNode = node.parent.parent.left;// 叔叔节点为祖父节点的左儿子
				if (pNode.color == RedBlackNode.RED) {// 叔叔、父亲都为红时，父叔涂黑，祖父涂红，祖父为当前节点
					node.parent.color = RedBlackNode.BLACK;
					pNode.color = RedBlackNode.BLACK;
					node = node.parent.parent;
				} else {
					if (node == node.parent.left) {// 叔叔为黑且当前节点为父节点左儿子时，以父为当前节点右旋
						node = node.parent;
						rightRotate(node);
					} else {// 叔叔为黑且当前节点为父节点右儿子时，父涂黑，祖父涂红，以祖父节点左旋，当前节点不变
						node.parent.color = RedBlackNode.BLACK;
						node.parent.parent.color = RedBlackNode.RED;
						leftRotate(node.parent.parent);
					}
				}
			}
		}
		root.color = RedBlackNode.BLACK;
	}
}
