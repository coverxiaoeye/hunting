package javase.multithread.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**  
 * @title 指定x个线程从第i个开始按照顺序运行，
 * 此方法中使用notifyall把所有wait的线程都唤醒，比较一下还没到自己就继续wait；
 * AlternateRun2类中每个线程有condition与之对应，精确唤醒指定线程。
 * @description 
 * @author ocaicai@yeah.net
 * @since 2013-8-17 下午12:51:11
 */
public class AlternateRunX implements Runnable {
	
	private int firstnum;//线程从1开始编号

    private int currentnum;// 当前执行线程编号,Thread Number,线程从1开始编号
    
    private int threadcount; //线程总个数，线程从1开始编号

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();
    
    /**
     * 指定x个线程从第i个开始按照顺序运行
     * @param threadcount 要启动的线程总数
     * @param firstnum 第一个要执行的线程编号
     */
    public AlternateRunX(int threadcount,int firstnum) {
		this.threadcount = threadcount;
		this.firstnum = firstnum;
		this.currentnum = firstnum;
	}

    public static void main(String[] args) {
        new AlternateRunX(8,2).run();
    }

    @Override
    public void run() {
    	
    	for (int i = 0; i < this.threadcount; i++) {
			new Thread(new WorkThread(i+1)).start();
		}
    }

    class WorkThread extends Thread {
    	private int threadnum;//线程编号
    	public WorkThread(int threadnum) {
			this.threadnum = threadnum;
		}

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (threadnum!=currentnum ) {// 判断是否该自己执行了[采用while不是if是为了防止死锁]
                    	condition.await();
                    }
                    System.out.println("Thread"+ threadnum + " is flashing...");

                    TimeUnit.SECONDS.sleep(1);// 停留时间，便于从控制台观看
                    
                    currentnum = (currentnum%threadcount)+1;
                    condition.signalAll();;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}