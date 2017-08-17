package javase.proxy.jdkdynamicproxylite;

public class TestProxy {

	public static void main(String[] args) {
		 //实例化一个实例
		 BookFacadeProxy proxy = new BookFacadeProxy();
		 //通过绑定委托对象返回一个代理类
		 BookFacade bookproxy = (BookFacade) proxy.bind(new BookFacadeImpl());
		 //调用代理类的方法，通过反射会把织入代码执行
		 bookproxy.addBook();
	}

}
