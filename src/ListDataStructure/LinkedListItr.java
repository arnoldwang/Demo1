package ListDataStructure;

public class LinkedListItr {
	ListNode current;

	LinkedListItr(ListNode node) {
		current = node;
	}

	public boolean isPastEnd() {
		return current == null;
	}

	public Object retrieve() {
		return isPastEnd() ? null : current.element;
	}

	public void advance() {
		if (!isPastEnd())
			current = current.next;
	}
}
