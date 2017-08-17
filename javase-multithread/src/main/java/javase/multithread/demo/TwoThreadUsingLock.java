package javase.multithread.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替执行，a线程打印123，b线程打印456 和打印次数，执行结果是123456 0 123456 1   123456 2 ......
 * @author shangjie
 *
 */
public class TwoThreadUsingLock {

	//private static Object LOCK = new Object();
	private static boolean flag = false;
	
	private static Lock lock = new ReentrantLock();
	private static Condition  condition = lock.newCondition();
	
	public static void main(String[] args) {

		Thread b = new Thread() {
			public void run() {
				for (int c = 0; c <= 100; c++) {
					lock.lock();
					try {
						for (int i = 4; i <= 6; i++) {
							System.out.print(i);
						}
						System.out.print(" " + c);
						System.out.println();
						if(flag){
							flag = false;
							condition.signal();
							if (c < 100) {
								try {
									condition.await();
									
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
						}
					}finally{
						lock.unlock();
					}

				}
			}
		};

		Thread a = new Thread() {
			public void run() {
				for (int c = 0; c <= 100; c++) {
					lock.lock();
					try {
						for (int i = 1; i <= 3; i++) {
							System.out.print(i);
						}
						if(!flag){
							flag = true;
							condition.signal();//在这里虽然唤醒了另一个线程b，但锁并没有释放
							if (c < 100) {
								try {
									condition.await();//在wait后的瞬间线程b得到锁
									
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
						}
					}finally{
						lock.unlock();
					}
				}
			}
		};

		a.start();
		b.start();
	}
}
