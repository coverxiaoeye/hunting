package javase.classloader.userdefined;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.ProtectionDomain;

public class FileSystemClassLoader00 extends ClassLoader {
	
	private String rootDir;
	
	/**
	 * @param rootDir 该classloader对应的根目录，用于读取类的字节码时使用
	 */
	public FileSystemClassLoader00(String rootDir) {
		super(null);
		this.rootDir = rootDir;
	}
	
	/**
	 * 重写父类的findClass方法，根据类的字节码调用defineClass加载类
	 */
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		}
		else {
			return defineClass(name, classData, 0, classData.length);
		}
	}
	 public Class<?> loadClass(String name) throws ClassNotFoundException {
		 if(name.indexOf("SimpleJavaFileObject")>0||name.indexOf("Math")>0)	{
			 return loadClass00(name, false);
		 }
		 return loadClass(name, false);
     }
	
	/**
	 * 重写父类的loadClass方法，去掉从BootstrapClassLoader加载器进行加载的代码
	 */
	protected synchronized Class<?> loadClass00(String name, boolean resolve)
			throws ClassNotFoundException
		    {
			// First, check if the class has already been loaded
			Class c = findLoadedClass(name);
			ClassLoader parent = getParent();
			if (c == null) {
			    try {
				if (parent != null) {
				    c = parent.loadClass(name);
				} 
			    } catch (ClassNotFoundException e) {
		                // ClassNotFoundException thrown if class not found
		                // from the non-null parent class loader
		            }
		            if (c == null) {
			        // If still not found, then invoke findClass in order
			        // to find the class.
			        c = findClass(name);
			    }
			}
			if (resolve) {
			    resolveClass(c);
			}
			return c;
		    }
	
	/**
	 * 根据class的全名读取类的字节码
	 * @param className
	 * @return
	 */
	private byte[] getClassData(String className) {
		String path = classNameToPath(className);
		try {
			InputStream ins = new FileInputStream(path);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];
			int bytesNumRead = 0;
			while ((bytesNumRead = ins.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesNumRead);
			}
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将class的全名变为文件的路径，
	 * 如javase.classloader.userdefined.FileSystemClassLoader 
	 * 变为“D://../../javase/classloader/userdefined/FileSystemClassLoader.class”
	 * @param className
	 * @return
	 */
	private String classNameToPath(String className) {
		return rootDir + File.separatorChar
				+ className.replace('.', File.separatorChar) + ".class";
	}
	
}
