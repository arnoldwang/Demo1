package List;

public class LinkedList {
	private ListNode header;

	public LinkedList() {
		header = new ListNode(null);
	}

	public boolean isEmpty() {
		return header.next == null;
	}

	public void makeEmpty() {
		header.next = null;
	}

	public LinkedListItr zeroth() {
		return new LinkedListItr(header);
	}

	public LinkedListItr first() {
		return new LinkedListItr(header.next);
	}

	public LinkedListItr find(Object x) {
		ListNode itr = header.next;

		while (itr != null && !itr.element.equals(x))
			itr = itr.next;

		return new LinkedListItr(itr);
	}

	public LinkedListItr findPrevious(Object x) {
		ListNode itr = header;

		while (itr.next != null && !itr.next.element.equals(x))
			itr = itr.next;

		return new LinkedListItr(itr);
	}

	public void remove(Object x) {
		LinkedListItr itrPre = findPrevious(x);
		if (itrPre.current.next != null)
			itrPre.current.next = itrPre.current.next.next;
	}

	public void insert(Object x, LinkedListItr p) {
		if (p != null && p.current != null)
			p.current.next = new ListNode(x, p.current.next);
	}

}
