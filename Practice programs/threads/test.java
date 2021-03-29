package threads;

/*
CAC Component 2
Program: Demonstrate the concept of thread life cycles, thread priority, thread synchronization, interthread communication
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/

// used to test threads and display various states. Also used for main function
class Test implements Runnable {
	public static Thread thread1;
	public static Test obj;

	public static void main(String[] args) {
		obj = new Test();
		thread1 = new Thread(obj);

		System.out.println("+----------------------------------------+");
		System.out.println("|       Thread States and Priority       |");
		System.out.println("+----------------------------------------+");
		System.out.println("");

		// sets thread 1 to max priority
		thread1.setPriority(Thread.MAX_PRIORITY);

		// prints thread1 state
		System.out.println("State of thread1 after creating it                         - " + thread1.getState());
		thread1.start();

		System.out.println("State of thread1 after calling .start() method on it       - " + thread1.getState());

		// used to delay later threads to show proper outputs
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("");
		System.out.println("+----------------------------------------+");
		System.out.println("|          Synchronized Threads          |");
		System.out.println("+----------------------------------------+");
		System.out.println("");


		// synchronized threads. will be jumbled with other threads tho
		Table tableObj = new Table();
		SyncThread1 t1 = new SyncThread1(tableObj);
		SyncThread2 t2 = new SyncThread2(tableObj);
		t1.start();
		t2.start();

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("");
		System.out.println("+----------------------------------------+");
		System.out.println("|       Inter Thread Communication       |");
		System.out.println("+----------------------------------------+");
		System.out.println("");

		// inter thread communication. also testing inline thread declaration
		// sometimes process excution can get interchanged
		InterThread ip = new InterThread();
		new Thread() {
			public void run() {
				ip.subtract(15000);
			}
		}.start();
		new Thread() {
			public void run() {
				ip.add(10000);
			}
		}.start();
	}

	public void run() {
		Customthread myThread = new Customthread();
		Thread thread2 = new Thread(myThread);
		// set to minimum priority
		thread2.setPriority(Thread.MIN_PRIORITY);

		// prints state of thread2
		System.out.println("State of thread2 after creating it                         - " + thread2.getState());
		thread2.start();

		// prints priority of current thread. Thread1
		System.out.println("Running thread1 priority                                   - " + Thread.currentThread().getPriority());

		System.out.println("State of thread2 after calling .start() method on it       - " + thread2.getState());

		// thread1 goes to sleep. used to show wait state
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("State of thread2 after calling .sleep() method on it       - " + thread2.getState());

		try {
			// waiting for thread2 to die
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("State of thread2 when it has finished it's execution       - " + thread2.getState());
	}
}

// used to test threads and display various states
class Customthread implements Runnable {
	public void run() {

		System.out.println("Running thread2 priority                                   - " + Thread.currentThread().getPriority());

		// thread2 goes to sleep. activated before thread1 sleep
		try	{
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("State of thread1 while it called join() method on thread2  - " + Test.thread1.getState());
		try { 
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

// used for synchronization
class Table {
	//synchronized method. prints numbers in sequence
	synchronized void printTable(int n) {
		System.out.println("Synchronized Thread");
		for(int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

// used for synchronization
class SyncThread1 extends Thread {
	Table t;
	SyncThread1(Table t) {
		this.t = t;
	}
	public void run() {
		t.printTable(5);
	}
}
class SyncThread2 extends Thread {
	Table t;
	SyncThread2(Table t) {
		this.t = t;
	}
	public void run() {
		t.printTable(100);
	}
}

// used for interthread communication
class InterThread {
	int number = 10000;
	
	synchronized void subtract(int number) {
		System.out.println(number + " will be subtracted from " + this.number);
	
		if(this.number < number) {
			System.out.println("Final cannout be less than 0. Waiting for addition");
			try {
				wait();
			} catch (Exception e) {
				// does nothing
			}
		}
		this.number -= number;
		System.out.println("Final number = " + this.number);
	}
	
	synchronized void add(int number) {
		System.out.println(number + " will be added to " + this.number);
		this.number += number;
		System.out.println("Final number = " + this.number);
		notify();
	}
}
