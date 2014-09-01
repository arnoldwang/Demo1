package ListDataStructure;

class ListNode {
	Object element;
	ListNode next;
	
	ListNode(Object element){
		this(element, null);
	}
	
	ListNode(Object element, ListNode next){
		this.element = element;
		this.next = next;
	}
}
