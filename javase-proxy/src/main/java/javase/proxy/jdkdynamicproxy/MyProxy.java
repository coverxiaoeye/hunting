package javase.proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* 
 * 每一个代理实例都必须指定一个调用处理器，代理对象调用方法时， 
 * 该方法会指派到调用处理器的invoke()中去。代理的方法封装成 
 * invoke中的method对象，其中的参数封装成Object[]. 
 */  

public class MyProxy implements InvocationHandler {
    //希望被代理的对象
	private Object obj;
	//要织入的横切操作
	private Advice advice;
	
	//绑定代理对象
	public Object bind(Object obj, Advice advice){
		this.obj = obj;
		this.advice = advice;
		
		return Proxy.newProxyInstance(
				obj.getClass().getClassLoader(), //类加载器
				obj.getClass().getInterfaces(), //创建目标类所需要使用的一组接口 
				this // 一个实现InvocationHandler的实例，用来整合横切与业务逻辑
				);
				
	}
	
	 //实现代理  
    /*
     * 参数说明： 
       Object proxy：指被代理的对象。 
       Method method：要调用的方法 
       Object[] args：方法调用时所需要的参数  
     * method为方法名，args为代理实例某一方法的入参数组，而obj为所属的实例对象--被代理的对象 
     */  
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
	    advice.before();
	    result = method.invoke(obj, args);
	    advice.after();
		return result;
	}

}
