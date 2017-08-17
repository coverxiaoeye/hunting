/**
 * 
 */
package javase.proxy.jdkdynamicproxy;

/**
 * @author wangyg
 * 
 */
public class TimeAdvice implements Advice{
	long startTime;
	long endTime;

	public void before() {
		//获取开始时间
		startTime = System.nanoTime();
		System.out.println("开始计算程序运行时间");
	}

	public void after() {
		//获取结束时间
		endTime = System.nanoTime();
		System.out.println("计算升序运行时间：" + (endTime - startTime) + "ns" );
		
	}

}
