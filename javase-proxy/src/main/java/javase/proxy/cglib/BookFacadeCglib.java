/**
 * 
 */
package javase.proxy.cglib;
import java.lang.reflect.Method;    
import net.sf.cglib.proxy.Enhancer;    
import net.sf.cglib.proxy.MethodInterceptor;    
import net.sf.cglib.proxy.MethodProxy;    

/**  
 * 使用cglib动态代理  
 */    
public class BookFacadeCglib implements MethodInterceptor {    
    private Object target;    
    
    /**  
     * 创建代理对象  
     * @param target  
     * @return  
     */    
    public Object getInstance(Object target) {    
        this.target = target;    
        Enhancer enhancer = new Enhancer();    
        enhancer.setSuperclass(this.target.getClass());  // 设置需要创建子类的类   
        // 回调方法    
        enhancer.setCallback(this);    
        // 通过字节码技术动态创建子类实例    
        return enhancer.create();    
    }    
    
    // 回调方法 ，拦截所有的父类方法调用   
    public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy) throws Throwable {    
        System.out.println("织入代码开始");    
        Object result = proxy.invokeSuper(obj, args);   // 通过代码类调用父类中的方法  
        System.out.println("织入代码结束");    
        return result;    
    }    
    
}    