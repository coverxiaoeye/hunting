/**
 * 
 */
package VisualVMTest;

/**

 * @Described£∫À¿À¯—› æ

 * @author YHJ create at 2012-3-26 œ¬ŒÁ05:46:36

 * @FileNmae com.yhj.monitor.Deadlock.java

 */

public class Deadlock implements Runnable{

 

    private int a;

    private int b;

    

    public Deadlock(int a, int b) {

       super();

       this.a = a;

       this.b = b;

    }

 

    @Override

    public void run() {

       synchronized (Integer.valueOf(a)) {

           synchronized (Integer.valueOf(b)) {

              System.out.println("a+b="+(a+b));

           }

       }

    }

    

    public static void main(String[] args) {

       for(int i = 0; i < 1000; ++i){

           new Thread(new Deadlock(1, 2)).start();

           new Thread(new Deadlock(2, 1)).start();

       }

    }

}
