package javase.proxy.jdkdynamicproxy;

public class ControlAdvice extends TimeAdvice {
	@Override
	public void before(){
		super.before();
		System.out.println("提前判断系统的权限 ");
	}
	
	@Override
	public void after(){
		super.after();
		System.out.println("判断系统的权限完毕");
	}
}
