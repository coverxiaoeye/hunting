package test;

/**
 * 测验发现：线程的synchronized方法会锁对象。。
 * @author wangyg
 *
 */


//测试类
public class TestThreadConcuurent {
	public static void main(String[] args) throws InterruptedException {
		MyExtendThread thread = new MyExtendThread(1);
		thread.start();
		//Thread.sleep(500);
		thread.canRun();
		System.out.println("end");
	}
}

//线程类
class MyExtendThread extends Thread {

	private int count = 1, number;

	public MyExtendThread(int num) {
		number = num;
		System.out.println("Create Thread-" + number);
	}

	@Override
	public synchronized void run() {
		while (true) {
			System.out.println("In Run Method");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread-" + number + " run " + count
					+ " time(s)");
			if (++count == 3)
				return;
		}
	}
	
	public synchronized void canRun() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("====canRun====");
	}
}