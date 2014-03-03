package linkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTest {

	private SingleLinkedList llist;		
	
	@Before
	public void setUp() throws Exception {
		// a new linked list will be created for each test
		llist = new SingleLinkedList();
	}

	@Test
	public void testAdd() {
		llist.add(7);
		SingleLinkedList.Node n = llist.get(1);
		assertTrue(n.data == 7);
		llist.add(8);
		n = llist.get(2);
		assertTrue(n.data == 8);
		print();
		
	}
	
	@Test
	public void testAddMany() {
		addNodes(10);
		SingleLinkedList.Node n = llist.get(1);
		assertTrue(n.data == 0);
		n = llist.get(10);
		assertTrue(n.data == 9);
		assertTrue(llist.size() == 10);
		print();
		
	}
	
	@Test
	public void testHasCycle() {
		addNodes(10);
		assertFalse(llist.hasCycle());
		llist.addLoopAtEnd(22, 4);
		assertTrue(llist.hasCycle());
	}

	@Test
	public void testGet() {
		addNodes(2);
		SingleLinkedList.Node n = llist.get(1);
		assertEquals(0, n.data);
		
	}

	@Test
	public void testFind() {
		addNodes(10);
		SingleLinkedList.Node n = llist.find(7);
		assertEquals(7, n.data);		
	}

	@Test
	public void testFindNthToLast() {
		addNodes(10);
		SingleLinkedList.Node n = llist.findNthToLast(2);
		assertEquals(7, n.data);		
		n = llist.findNthToLast(0);
		assertEquals(9, n.data);		
		n = llist.findNthToLast(20);
		assertEquals(0, n.data);		
	}

	@Test
	public void testReverse() {
		addNodes(10);
		llist.reverse();
		assertTrue(isReversed(10));
		
	}
	
	boolean isReversed(int size) {
		//SingleLinkedList.Node head = 
		for (int i=1; i<=llist.size(); i++) {
			if (llist.get(i).data != size-1) {
				return false;
			}
			size--;
		}
		return true;
	}

	@Test
	public void testDeleteNode() {		
		addNodes(10);
		SingleLinkedList.Node n = llist.get(1);		
		llist.delete(n);
		assertFalse(hasValue(0));
		
	}

	@Test
	public void testDeleteInt() {
		addNodes(10);
		llist.delete(7);
		assertFalse(hasValue(7));
		
	}

	@Test
	public void testDeleteAll() {
		addNodes(10);
		print();
		assertTrue(llist.size() == 10);
		llist.deleteAll();
		assertTrue(llist.size() == 0);
		print();
	}

	boolean hasValue(int val) {
		//SingleLinkedList.Node head = 
		for (int i=1; i<=llist.size(); i++) {
			if (llist.get(i).data == val) {
				return true;
			}
		}
		return false;
	}
	
	public void addNodes(int numNodes) {
		for (int i=0; i < numNodes; i++) {
			llist.add(i);
		}
	}
	
	public void print() {
		System.out.println(llist.toString());
	}



}
