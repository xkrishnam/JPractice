package threadexp;

/*
- to demonstrate what happens if one thread from thread group exits with
	runtime exception - other threads continues
 */
public class ThreadTest {

	public static void main(String[] args) {

		Lock lock = new Lock();
        ThreadGroup threadGroup=new ThreadGroup("incrementers ");
		for (int i = 0; i < 100; i++) {
			new Thread(threadGroup,lock, String.valueOf(i)).start();
		}

		System.out.println("end");
	}

}

class Lock implements Runnable {

	int counter = 0;

	@Override
	public void run() {
		increment();
	}

	private synchronized void increment() {
		System.out.println("Thread number: " + Thread.currentThread().getName() + " increment call");
		counter++;
		printVal();
		try {
			Thread.currentThread().sleep(3000L);
		} catch (InterruptedException e) {
		} finally {
			System.out.println("Thread number: " + Thread.currentThread().getName() + " execution complete");
		}
		if (counter == 4) {
			System.out.println("Thread number: " + Thread.currentThread().getName() + " is failing at runtime");
			//notifyAll();
			throw new RuntimeException("Thread " + Thread.currentThread().getName() + " is failing at runtime");
		}
	}

	private void decrement() {
		counter--;
	}

	private void printVal() {
		System.out.println("Thread number: " + Thread.currentThread().getName() + " printing value " + counter);
		System.out.println("Active : "+Thread.currentThread().getThreadGroup().activeCount());
	}
}
