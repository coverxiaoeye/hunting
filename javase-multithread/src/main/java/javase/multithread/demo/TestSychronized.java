package javase.multithread.demo;

//public class TestSychronized {
//    static TestSychronized instance = new TestSychronized();
//    public static void main(String[] args) {
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//                public synchronized void run() {
//                    
//                    for(int i=1; i<4; i++) {
//                        try {
//                            Thread.sleep(200);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println("Thread1 still alive, " + i);
//                    }                    
//                }
//        });
//        new Thread(thread1).start();
//        new Thread(thread1).start();
//    }
//}
public class TestSychronized {
    public synchronized static void method1() throws InterruptedException {
        System.out.println("method1 begin at:" + System.currentTimeMillis());
        Thread.sleep(6000);
        System.out.println("method1 end at:" + System.currentTimeMillis());
    }
    public synchronized static void method2() throws InterruptedException {
        while(true) {
            System.out.println("method2 running");
            Thread.sleep(200);
        }
    }
    static TestSychronized instance1 = new TestSychronized();
    static TestSychronized instance2 = new TestSychronized();
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    instance1.method1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=1; i<4; i++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread1 still alive");
                }                    
            }
        });
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    instance2.method2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        thread1.start();
        thread2.start();    
        
    }
}