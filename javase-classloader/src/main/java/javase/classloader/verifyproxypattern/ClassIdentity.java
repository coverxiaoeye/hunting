package javase.classloader.verifyproxypattern;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javase.classloader.userdefined.FileSystemClassLoader;

public class ClassIdentity {

	// 检验通过不同类加载器加载的同一个类是否一致
	public static void main(String[] args) {
		new ClassIdentity().testClassIdentity();

	}

	private void testClassIdentity() {
		String classDataRootPath = "D:\\SourceCodes\\folderforclass";
		FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
		FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
		String className = "javase.classloader.verifyproxypattern.Sample";	
		try {
		Class<?> class1 = fscl1.loadClass(className);
		Object obj1 = class1.newInstance();
		Class<?> class2 = fscl2.loadClass(className);
	    Object obj2 = class2.newInstance();
	    System.out.println(class1.getClassLoader());
	    System.out.println(class2.getClassLoader());
	    Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
	    setSampleMethod.invoke(obj1, obj2);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
