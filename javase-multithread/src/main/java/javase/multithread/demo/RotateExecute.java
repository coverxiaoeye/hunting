package javase.multithread.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个工作线程轮流执行
 * @author wangyg
 *
 */

public class RotateExecute {

	private Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	public static boolean Type1flag = true;

	public static void main(String[] args) {
		RotateExecute instance = new RotateExecute();
		WorkerType1 workera = instance.new WorkerType1("workera");
		WorkerType2 workerb = instance.new WorkerType2("workerb");

		workera.start();
		workerb.start();
	}

	class WorkerType1 extends Thread {
		String name = "";

		public WorkerType1(String name) {
			this.name = name;
		}

		public void run() {

			for (int i = 0; i <= 10; i++) {

				lock.lock();
				try {
					System.out.println(name + " is doing the " + i + " work");

					if (Type1flag) {
						Type1flag = false;
						condition.signal();
						if (i < 10) {
							condition.await();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}

			}
		}
	}

	class WorkerType2 extends Thread {
		String name = "";

		public WorkerType2(String name) {
			this.name = name;
		}

		public void run() {

			for (int i = 0; i <=10; i++) {
				lock.lock();
				try {
					System.out.println(name + " is doing the " + i + " work");
					if (!Type1flag) {
						Type1flag = true;
						condition.signal();
						if (i < 10) {
							condition.await();
						}
					}
				} catch (InterruptedException e) {
                    e.printStackTrace();
				} finally {
					lock.unlock();
				}

			}
		}
	}
}
