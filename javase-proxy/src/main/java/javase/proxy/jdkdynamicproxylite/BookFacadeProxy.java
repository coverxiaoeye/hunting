package javase.proxy.jdkdynamicproxylite;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理代理类 
 * @author wangyg
 *
 */
public class BookFacadeProxy implements InvocationHandler {

	private Object target;
	
	/**
	 * 绑定委托对象并返回一个代理类
	 * @param target
	 * @return
	 */
	public Object bind(Object target){
		this.target = target;
		//取得代理对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this); //这里第二个参数必须要绑定接口
	}
	
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		System.out.println("织入信息开始");
		result = method.invoke(target, args);
		System.out.println("织入信息结束");
				
		return null;
	}

}
