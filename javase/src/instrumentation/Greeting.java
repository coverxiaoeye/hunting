package instrumentation;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;

/**
 * A trivial example program that basically just says hello!
 */
public class Greeting implements ClassFileTransformer {

    public static void premain(String options, Instrumentation ins) {
        if (options != null) {
            System.out.printf("  I've been called with options: \"%s\"\n",
                    options);
        } else
            System.out.println("  I've been called with no options.");
        ins.addTransformer(new Greeting());
    }

    public byte[] transform(ClassLoader loader, String className, Class cBR,
            java.security.ProtectionDomain pD, byte[] classfileBuffer)
            throws IllegalClassFormatException {
        System.out.println("Hello,\t"+className);
        return null; //返回 null 值，表示不需要进行类字节码的转化
    }

    private final TrivialShutdownHook _hook = new TrivialShutdownHook();

    class TrivialShutdownHook extends Thread {
        public TrivialShutdownHook() {
            Runtime.getRuntime().addShutdownHook(this);
        }

        public void run() {
            try {
                System.out.println("The JVM is shutting down now!");
            } catch (Throwable e) {
                System.err.println("PrintClassOnShutdown::run " + e);
            }
        }
    }

} // class TrivialInstrumenter
