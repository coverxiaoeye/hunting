package javase.externalizable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizableTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("------创建原始对象------------");
		Blip blip = new Blip("This String is", 47);
		System.out.println("创建的原始对象：");
		System.out.println(blip);
		
		System.out.println("------序列化操作，writeObject------------");
		ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutStream = new ObjectOutputStream(byteOutStream);
		objectOutStream.writeObject(blip);
		
		System.out.println("------反序列化之后，readObject------------");
		ByteArrayInputStream byteInStream = new ByteArrayInputStream(byteOutStream.toByteArray());
		ObjectInputStream objectInStream = new ObjectInputStream(byteInStream);
		Blip blipAnother = (Blip)objectInStream.readObject();
		System.out.println("反序列化后的对象：");
		System.out.println(blipAnother);
	}

}
