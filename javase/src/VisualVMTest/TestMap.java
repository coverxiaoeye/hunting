/**
 * 
 */
package VisualVMTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyg
 *
 */
public class TestMap {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Map<Integer,String> memory  = new HashMap<Integer, String>();
		
		for (int i = 0; i < 1000; i++) {
			memory.put(i, "I am "+i);
		}
		System.out.println("Runing");
		Thread.sleep(10000);
		for (int i = 1000; i < 2000; i++) {
			memory.put(i, "I am "+i);
		}
		Thread.sleep(1000000);
		memory.put(10000, "I am the terminator!");
		memory.get(32);
	}

}
