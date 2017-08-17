package java.lang;

/**
 * 自己编写的类，在rt.jar包中的java.lang.*中存在同名的类
 * 运行报错：java.lang.NoSuchMethodError: main，因为bootstrapclassloader默认加载了jdk自带的类，并且其中没有main方法
 * @author wangyg
 *
 */
public final class Math{
	public  Math(){
		super();
	}
	public static void main(String[] args) {
		System.out.println("Self-defined class:java.lang.Math");  
	}
	
	public int pingfang(int a){
		return a*a;
	}
}
