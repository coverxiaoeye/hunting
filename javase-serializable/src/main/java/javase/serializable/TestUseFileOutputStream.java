package javase.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化/反序列化操作采用FileOutputStream来进行操作
 * @author wangyg
 *
 */
public class TestUseFileOutputStream {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("------创建原始对象------------");
		House house = new House();
		house.setName("room1");
		Animal animal = new Animal("dog1", house);
		System.out.println("创建的原始对象：");
		System.out.println(animal);
		
		System.out.println("------开始序列化------------");
		FileOutputStream fileOutStream = new FileOutputStream("animal.txt");
		ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutStream);
		objectOutStream.writeObject(animal);
		objectOutStream.flush();
		objectOutStream.close();
		
		System.out.println("------开始反序列化------------");
		FileInputStream fileInStream = new FileInputStream("animal.txt");
		ObjectInputStream objectInStream = new ObjectInputStream(fileInStream);
		Animal animalAuto = (Animal)objectInStream.readObject();
		objectInStream.close();
		System.out.println("反序列化后的对象：");
		System.out.println(animalAuto);
		
		

	}
	

}
