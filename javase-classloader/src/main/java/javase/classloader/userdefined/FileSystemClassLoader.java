package javase.classloader.userdefined;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemClassLoader extends ClassLoader {
	
	private String rootDir;
	
	/**
	 * @param rootDir 该classloader对应的根目录，用于读取类的字节码时使用
	 */
	public FileSystemClassLoader(String rootDir) {
		//super(null);
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
