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
public class TestString {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		String a = "1234213423sdfsdfsdfsdfsdfasdfdsfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
		
		Thread.sleep(60000);
		
		String b = a.substring(0,20);
		System.out.println(b);
	}

}
