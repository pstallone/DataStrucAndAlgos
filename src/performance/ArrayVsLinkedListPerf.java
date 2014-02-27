package performance;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ArrayVsLinkedListPerf {
	
	private ArrayList<Integer> arrlist;
	private LinkedList<Integer> llist;
	
	public ArrayVsLinkedListPerf() {
		arrlist = new ArrayList<Integer>(1000000);
		llist = new LinkedList<Integer>();
	}
	

	public void addToEndArr(int n) {
		// array should not grow since init capacity is 1M
		long start = System.nanoTime();
		for (int i=0; i < n; i++) {		
			arrlist.add(i);
		}		
		System.out.println((System.nanoTime() - start)/1000 + " usec for addToEndArr(" + n + ")");
	}

	public void addToEndLL(int n) {
		
		long start = System.nanoTime();
		for (int i=0; i < n; i++) {		
			llist.add(i); // has a tail pointer
		}		
		System.out.println((System.nanoTime() - start)/1000 + " usec for addToEndLL(" + n + ")");
		
	}

	public void addToBeginArr(int n) {

		long start = System.nanoTime();
		for (int i=0; i < n; i++) {		
			arrlist.add(0, i);
		}		
		System.out.println((System.nanoTime() - start)/1000 + " usec for addToBeginArr(" + n + ")");
	}
	
	public void addToBeginLL(int n) {
		
		long start = System.nanoTime();
		for (int i=0; i < n; i++) {		
			llist.addFirst(n);
		}	
		System.out.println((System.nanoTime() - start)/1000 + " usec for addToBeginLL(" + n + ")");
	}


	public void addToMiddleArr(int n) {

		long start = System.nanoTime();
		for (int i=0; i < n; i++) {		
			arrlist.add(arrlist.size()/2, n); // shifts then adds
		}	
		System.out.println((System.nanoTime() - start)/1000 + " usec for addToMiddleArr(" + n + ")");
	}

	public void addToMiddleLL(int n) {
		
		long start = System.nanoTime();
		for (int i=0; i < n; i++) {		
			llist.add(llist.size()/2, n); // traverses to middle
		}	
		System.out.println((System.nanoTime() - start)/1000 + " usec for addToMiddleLL(" + n + ")");		
		
	}

	
	public static void main(String[] args) {
		
		int n = 10000;
		ArrayVsLinkedListPerf avll = new ArrayVsLinkedListPerf();
		avll.addToEndArr(n);
		avll.addToEndLL(n);
		avll.addToBeginArr(n);
		avll.addToBeginLL(n);
		avll.addToMiddleArr(n);
		avll.addToMiddleLL(n);
		
	}
}
