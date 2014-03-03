package linkedlist;

public class SingleLinkedList {
	
	class Node {
		int data;
		Node next;
	}
	private Node head;

	public SingleLinkedList() {
		
	}
	
	// FIXME: inefficient - replace with a size variable that is maintained
	public int size() {
		int i = 0;
		Node n = head;
		if (head == null) {
			return 0;
		}
		while (n != null) {
			i++;
			n = n.next;
		}
		return i;
		
	}
	
	// add node to end
	public void add(int data) {
		Node node = new Node();
		node.data = data;
	
		if (head == null) {
			head = node;
			return;
		}
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = node;
	}
	
	public void addLoopAtEnd(int data, int loopToIdx) {

		Node node = new Node();
		node.data = data;
	
		if (head == null) {
			head = node;
			return;
		}
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = node;
		
		Node loopTo = head;
		int i = 1;
		while (loopTo != null && i < loopToIdx) {
			i++;
			loopTo = loopTo.next;			
		}
		node.next = loopTo;

	}
	
	// get Node at index where first node is index=1
	public Node get(int index) {
		Node n = head;
		int i = 1;
		// index must be a positive int
		if (index <= 0) {
			return null;
		}
		while (n != null) {
			if (i == index) {
				return n;
			}
			i++;
			n = n.next;
		}
		return null;
	}
	
	public Node find(int val) {
		Node n = head;
		while (n != null) {
			if (n.data == val) {
				return n;
			}
			n = n.next;
		}
		return null;
	}
	
	public Node findNthToLast(int nth) {
		// usage: if n=3, return 3rd to last node, first to last means one before last.
		// if nth to last is past the 0th node, return the 0th node.
		Node leadptr = head;
		Node nthptr = head;
		// advance nth places
		int i=0;
		while (leadptr.next != null) {
			if (i >= nth) {
				break;
			}
			leadptr = leadptr.next;
			i++;
		}
		while (leadptr.next != null) {
			nthptr = nthptr.next;
			leadptr = leadptr.next;
		}
		return nthptr;
		
	}
	
	public void reverse() {
		Node n = head;
		Node prev = null;
		while (n != null) {
			n = n.next;
			head.next = prev;
			prev = head;
			head = n;
		}
		head = prev;
	}
	
	// delete Node
	public boolean delete(Node n) {
		Node p = head;
		if (head == null || n == null)
			return false;
		if (head == n) {
			head = head.next;
			return true;
		}
		while (p != null) {
			if (p.next == n) {
				p.next = n.next;
				n = null; // necessary? Don't think so.
				return true;
			}
			p = p.next;
		}
		return false;
	}
	
	// delete first Node that has passed in value 
	public boolean delete(int val) {
		Node p = head;
		if (head == null)
			return false;
		if (head.data == val) {
			head = head.next;
			return true;
		}
		while (p != null) {
			if (p.next.data == val) {
				p.next = p.next.next;
				return true;
			}
			p = p.next;
		}
		return false;
	}
	
	public void deleteAll() {
		Node n = head;
		while (n != null) {
			n = n.next;
			head = n;
		}
	}
	
	public boolean hasCycle() {
		Node fast = head;
		Node slow = head;
		
		if (head == null) {
			return false;
		}
		while (fast != null && fast.next != null) {
			if (fast.next == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
		
	}
	
	
	public String toString() {
		Node n = head;
		if (head == null) {
			return "";
		}
		StringBuffer sbuf = new StringBuffer();
		while (n.next != null) {
			sbuf.append(n.data).append("->");
			n = n.next;
		}
		sbuf.append(n.data);
		return sbuf.toString();
	}

}
