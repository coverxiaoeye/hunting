package javase.classloader.tree;

public class ClassLoaderTree {

	public static void main(String[] args) {
		ClassLoader loader = ClassLoaderTree.class.getClassLoader();
		/* 自下而上一步步遍历输出类加载器的树状结构
		 * sun.misc.Launcher$AppClassLoader@3e25a5
         * sun.misc.Launcher$ExtClassLoader@19821f
         * 
         * 需要注意的是这里并没有输出引导类加载器，这是由于有些 JDK 的实现对于父类加载器是引导类加载器的情况，getParent()方法返回 null
		 */
		while (loader != null) {
			System.out.println(loader.toString());
			loader = loader.getParent();
		}
		
		//Class对象是在加载类时由 Java 虚拟机以及通过调用类加载器中的 defineClass 方法自动构造的,可以通过class对象的getName()方法来显示对象对应的类名
		ClassLoaderTree instance = new ClassLoaderTree();
		System.out.println("The class of " +instance + " is "+instance.getClass().getName());
	}

}
