package javalangtest;

import java.lang.Class;
import java.lang.ClassNotFoundException;
import java.lang.IllegalAccessException;
import java.lang.InstantiationException;
import java.lang.Object;
import java.lang.SecurityException;
import java.lang.String;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.Math;

import javase.classloader.userdefined.FileSystemClassLoader;
import javase.classloader.userdefined.FileSystemClassLoader00;

public class Test {

	/**
	 * 因为ClassLoader类中的defineClass方法会对包名进行验证
                         （以java.开头的包路径会报java.lang.SecurityException: Prohibited package name），
                            并且defineClass是protected final修饰的，无法重写，
                            所以对包名是java.*（以java开头）的自定义类，即使自定义一个ClassLoader也无法加载
                            
                   抛出异常：java.lang.SecurityException: Prohibited package name: java.lang
	 * @param args
	 */
	public static void main(String[] args) {
		String classDataRootPath = "D:\\SourceCodes\\Study\\Interview\\javase-classloader\\target\\classes";
		FileSystemClassLoader00 fscl00 = new FileSystemClassLoader00(classDataRootPath);
		String className = "java.lang.Math";	
		try {
		Class<?> class1 = fscl00.loadClass(className);
		System.out.println(class1.getClassLoader());
		Object obj1 = class1.newInstance();
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
		}
	}
}
