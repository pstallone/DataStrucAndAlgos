package concurrency;
import java.util.ArrayList;
import java.util.List;

/*
 * Got this from Brian Caracciolo from the Cypress Group as an answer to an interview prep question.
 * The question was:
 *   
 * Write a thread safe class that will be accessed by one producer thread and one consumer thread. 
 * You canÕt use any locking scheme (no synchronization, lock free code).
 */

public class NoLockProducerConsumer {

	private volatile List list = new ArrayList();
	private volatile int readIndex = 0;

	public void writeList(Object obj) {

		list.add(obj);
	}

	public Object readList() {

		if (readIndex > list.size() - 1)
			return null;

		return list.get(readIndex++);

	}
	
	// I added the main to test it out.
	
	class HelloRunnable implements Runnable {

	    public void run() {
	        System.out.println("Hello from a thread!");
	    }

	}
	
	
	public static void main(String[] args) {
		
		//NoLockProducerConsumer pc = 
		//new Thread(new NoLockProducerConsumer.HelloRunnable()).start();
	}

}
