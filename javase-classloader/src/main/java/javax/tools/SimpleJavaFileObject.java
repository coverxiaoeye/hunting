package javax.tools;

/**
 * 
 * 自己编写的类，在rt.jar包的javax.tools.*中存在同名的类
 * 运行报错：java.lang.NoSuchMethodError: main，因为bootstrapclassloader默认加载了jdk自带的类，并且其中没有main方法
 * @author wangyg
 *
 *
 */
public class SimpleJavaFileObject {

	public static void main(String[] args) {
		System.out.println("Self-defined class:javax.tools.SimpleJavaFileObject");  
	}
	
	public int pingfang(int a){
		return a*a;
	}
	
	public String toString(){
		return "Self-defined class:javax.tools.SimpleJavaFileObject";
	}
}
