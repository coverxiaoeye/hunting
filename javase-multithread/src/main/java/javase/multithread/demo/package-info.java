/**
 * 演示两个线程轮流执行的示例代码,其中AlternateRun2这个最规范、最值得借鉴
 * 
 * 解决notify和notifyall早期通知的总结

    在使用线程的等待/通知机制时，
     a、一般都要在while循环中调用wait（）方法，满足条件时，才让while循环退出
     b、一般也要配合配合使用一个boolean变量值（或其他能判断真假的条件，如list.isEmpty()），满足while循环的条件在notify之前改变该boolean变量的值，即使在通知被遗漏后，也可以通过该boolean值的判断让wait返回后能够退出while循环，不会被阻塞在wait方法处。这样便保证了程序的正确性

    扩展：引入boolean变量值是为了解决notify早期通知的问题，但如果使用if判断还会有notifyall早期通知问题，所以建议是在while循环中做条件判断。

 */
/**
 * @author wangyg
 *
 */
package javase.multithread.demo;