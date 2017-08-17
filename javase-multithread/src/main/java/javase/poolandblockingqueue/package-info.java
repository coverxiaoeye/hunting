/**
 * 对应博文：<Java多线程-工具篇-BlockingQueue>
 */
/**
 * @author wangyg
 * <br/>
 * 生产者、消费者使用BlockingQueue共享数据，无需自己进行加锁同步，
 * 而生产者和消费者线程使用Executors.newCachedThreadPool（）得到的线程池进行 调度
 */
package javase.poolandblockingqueue;

