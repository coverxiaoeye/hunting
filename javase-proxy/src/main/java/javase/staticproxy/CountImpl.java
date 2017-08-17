package javase.staticproxy;

/**
 *  委托类(包含业务逻辑) 
 * @author wangyg
 *
 */
public class CountImpl implements Count {

	public void queryCount() {
		System.out.println("查看账户方法...");  

	}

	public void updateCount() {
		 System.out.println("修改账户方法..."); 
	}

}
