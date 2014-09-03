package RedBlackTree;

public class RedBlackTree {

	private RedBlackNode root;

	public RedBlackTree() {
		root = RedBlackNode.NILL;
	}

	public RedBlackTree(Comparable element) {
		root = new RedBlackNode(element, RedBlackNode.BLACK);
		root.parent = RedBlackNode.NILL;
	}

	public void insert(Comparable element) {
		insert(new RedBlackNode(element, RedBlackNode.RED));
	}

	private void insert(RedBlackNode node) {
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

	// 左旋转
	private RedBlackNode leftRotate(RedBlackNode node) {
		if (node == null || node == RedBlackNode.NILL)
			return node;
		RedBlackNode k1 = node.right;
		node.right = k1.left;
		k1.left.parent = node;
		k1.left = node;
		k1.parent = node.parent;
		if (node.parent == RedBlackNode.NILL)
			root = k1;
		else if (node == node.parent.left)
			node.parent.left = k1;
		else
			node.parent.right = k1;
		node.parent = k1;
		return k1;
	}

	// 右旋
	private RedBlackNode rightRotate(RedBlackNode node) {
		if (node == null || node == RedBlackNode.NILL)
			return node;
		RedBlackNode k1 = node.left;
		node.left = k1.right;
		k1.right.parent = node;
		k1.right = node;
		k1.parent = node.parent;
		if (node.parent == RedBlackNode.NILL)
			root = k1;
		else if (node == node.parent.left)
			node.parent.left = k1;
		else
			node.parent.right = k1;
		node.parent = k1;
		return k1;
	}

	// 查找最小节点
	private RedBlackNode findMinNode(RedBlackNode node) {
		if (node == null || node == RedBlackNode.NILL)
			return RedBlackNode.NILL;
		while (node.left != RedBlackNode.NILL) {
			node = node.left;
		}

		return node;
	}

	// 查找最大节点
	private RedBlackNode findMaxNode(RedBlackNode node) {
		if (node == null || node == RedBlackNode.NILL)
			return RedBlackNode.NILL;
		while (node.right != RedBlackNode.NILL)
			node = node.right;

		return node;

	}

	// 删除节点
	private RedBlackNode delete(RedBlackNode node) {
		if (node == null || node == RedBlackNode.NILL)
			return RedBlackNode.NILL;

		RedBlackNode pNode;
		if (node.left == RedBlackNode.NILL || node.right == RedBlackNode.NILL)
			pNode = node;
		else
			pNode = findMaxNode(node.left);

		RedBlackNode nNode;
		if (pNode.left != RedBlackNode.NILL)
			nNode = pNode.left;
		else
			nNode = pNode.right;

		nNode.parent = pNode.parent;
		if (pNode == pNode.parent.left)
			pNode.parent.left = nNode;
		else
			pNode.parent.right = nNode;

		// 将后继节点赋值过去
		if (pNode != node)
			node.element = pNode.element;

		// 如果实际删除的节点为黑色，则会破坏红黑树规则，需要修复
		if (pNode.color == RedBlackNode.BLACK)
			brDeleteFixup(nNode);

		return pNode;
	}

	/**
	 * 删除一个黑节点后，修复红黑树
	 * 
	 * @param nNode
	 */
	private void brDeleteFixup(RedBlackNode node) {
		// TODO Auto-generated method stub
		if (node == null)
			return;

		// 补位节点如果为红色或者为根节点，则直接将其颜色变为黑色即修复成功，若为黑色需要继续判断
		while (node != root && node.color == RedBlackNode.BLACK) {
			if (node == node.parent.left) {// 当前节点为父亲的左儿子
				RedBlackNode bNode = node.parent.right;// 当前节点的兄弟节点
				if (bNode.color == RedBlackNode.RED) {
					// 兄弟节点为红，则把兄弟节点涂黑，父节点涂红，并在父节点左旋，重新指定兄弟节点
					bNode.color = RedBlackNode.BLACK;
					node.parent.color = RedBlackNode.RED;
					leftRotate(node.parent);
					bNode = node.parent.right;
				}
				if (bNode.left.color == RedBlackNode.BLACK
						&& bNode.right.color == RedBlackNode.BLACK) {
					// 兄弟节点为黑，且两个子侄都为黑，则兄弟涂红，当前节点为其父节点，重新进入循环
					bNode.color = RedBlackNode.RED;
					node = node.parent;
					continue;
				} else {
					if (bNode.right.color == RedBlackNode.BLACK) {

						// 兄弟节点为黑，兄弟的右儿子为黑，左儿子为红，则兄左儿子涂黑，兄弟涂红，在兄弟节点右旋，重新指定兄弟节点
						bNode.left.color = RedBlackNode.BLACK;
						bNode.color = RedBlackNode.RED;
						rightRotate(bNode);
						bNode = node.parent.right;
					} else {
						// 兄弟节点为黑，兄弟右儿子为红，左儿子随意颜色，则将兄弟涂为父亲颜色，父亲涂黑，兄弟右儿子涂黑，在父亲节点左旋
						// 到此分支调整完毕后，红黑树修复
						bNode.color = node.parent.color;
						bNode.right.color = RedBlackNode.BLACK;
						leftRotate(node.parent);
						node = root;
					}
				}
			}else{//当前节点为父亲的右儿子，镜像处理
				RedBlackNode bNode = node.parent.left;
				if(bNode.color == RedBlackNode.RED){
					bNode.color = RedBlackNode.BLACK;
					node.parent.color = RedBlackNode.RED;
					rightRotate(node.parent);
					bNode = node.parent.left;
				}
				if(bNode.left.color == RedBlackNode.BLACK && bNode.right.color == RedBlackNode.BLACK){
					bNode.color = RedBlackNode.RED;
					node = node.parent;
					continue;
				}else{
					if(bNode.left.color == RedBlackNode.BLACK){
						bNode.right.color = RedBlackNode.BLACK;
						bNode.color = RedBlackNode.RED;
						leftRotate(bNode);
						bNode = node.parent.left;
					}else{
						bNode.color = node.parent.color;
						node.parent.color = RedBlackNode.BLACK;
						bNode.left.color = RedBlackNode.BLACK;
						rightRotate(node.parent);
						node = root;
					}
				}
			}
		}
		node.color = RedBlackNode.BLACK;
	}

}
