package javase.proxy.jdkdynamicproxy;

public class TestClient {

	public static void main(String[] args) {
	    /* 
         *  如果Salary未实现SalaryInterface或者其他接口，此处proxy.bind()得到的实例在class cast时会报错
         *  所以说它只能为接口创建代理实例 
         */  
		ControlAdvice adv1 = new ControlAdvice();   
        SalaryInterface p = new Salary();  
          
        MyProxy proxy = new MyProxy();  
          
        SalaryInterface y = (SalaryInterface)proxy.bind(p, adv1); 
        y.doSalary();// 相当于调用proxy.invoke(proxy, "doSalary, null);  

	}

}
