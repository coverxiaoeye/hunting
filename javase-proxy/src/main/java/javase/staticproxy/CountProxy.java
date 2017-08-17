package javase.staticproxy;

/**
 * 每一个代理类只能为一个接口服务，这样一来程序开发中必然会产生过多的代理，
 * 而且，所有的代理操作除了调用的方法不一样之外，其他的操作都一样，则此时肯定是重复代码。
 * 解决这一问题最好的做法是可以通过一个代理类完成全部的代理功能，那么此时就必须使用动态代理完成。 
 * @author wangyg
 *
 */
public class CountProxy implements Count {

	private CountImpl countImpl;  
	  
    /** 
     * 覆盖默认构造器 
     *  
     * @param countImpl 
     */  
    public CountProxy(CountImpl countImpl) {  
        this.countImpl = countImpl;  
    }  
    
	public void queryCount() {
		System.out.println("queryCount处理之前");
		// 调用委托类的方法
		countImpl.queryCount();
		System.out.println("queryCount处理之后");
	}

	public void updateCount() {
		System.out.println("updateCount处理之前");
		// 调用委托类的方法
		countImpl.updateCount();
		System.out.println("updateCount处理之后");

	}

}
