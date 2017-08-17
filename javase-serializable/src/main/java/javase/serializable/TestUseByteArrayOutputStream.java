package javase.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化/反序列化操作采用ByteArrayOutputStream来进行操作
 * @author wangyg
 *
 */
public class TestUseByteArrayOutputStream {

	/*
	 * 结论：
	 * 1. 反序列化后的对象，需要调用构造函数重新构造吗？
	 * 答案： 不需要
	 * 2. 序列前的对象与序列化后的对象是什么关系？是("=="还是equal？是浅复制还是深复制？)
	 * 答案：深复制，反序列化还原后的对象地址与原来的的地址不同。
	 * 
	 * 补充：序列化前后对象的地址不同了，但是内容是一样的，而且对象中包含的引用的值也相同。 此例中Date也是实现了Serializable。
	 * 换句话说，通过序列化操作，我们可以实现对任何可Serializable对象的”深度复制（deep copy）"
	 * ——这意味着我们复制的是整个对象网，而不仅仅是基本对象及其引用。
	 * 对于同一流的对象，他们的地址是相同，说明他们是同一个对象，但是与其他流的对象地址却不相同。
	 * 也就说，只要将对象序列化到单一流中，就可以恢复出与我们写出时一样的对象网，而且只要在同一流中，对象都是同一个。
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("------创建原始对象------------");
		House house = new House();
		house.setName("room1");
		Animal animal = new Animal("dog1", house);
		System.out.println("创建的原始对象：");
		System.out.println(animal);
		
		System.out.println("------开始序列化------------");
		ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutStream = new ObjectOutputStream(byteOutStream);
		objectOutStream.writeObject(animal);
		objectOutStream.flush();
		objectOutStream.close();
		
		System.out.println("------开始反序列化------------");
		ByteArrayInputStream byteInStream  = new ByteArrayInputStream(byteOutStream.toByteArray());
		ObjectInputStream objectInStream = new ObjectInputStream(byteInStream);
		Animal animalAuto = (Animal)objectInStream.readObject();
		objectInStream.close();
		System.out.println("反序列化后的对象：");
		System.out.println(animalAuto);
		
		

	}
	

}
