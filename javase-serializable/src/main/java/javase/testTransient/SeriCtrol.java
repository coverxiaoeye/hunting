package javase.testTransient;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <b>Externalizable的替代方法</b><br/>
 * <ul>
 * <li>如果不是特别坚持实现Externalizable接口，那么我们可以通过实现Serializable接口，并添加名为writeObject()
 * 和readObject()方法。</li>
 * （注意：这里用的是添加而不是“覆盖”或者“实现”，因为这两个方法不是基类Object也不是接口Serializable中的方法）。
 * <li>这样一旦对象被序列化或者反序列还原，就会自动地分别调用者两个方法。也就是说，只要我们提供了这两个方法，就会使用它们而不是默认的序列化机制。</li>
 * </ul>
 * 
 * @author wangyg
 * 
 */
public class SeriCtrol implements Serializable {

	private static final long serialVersionUID = 1L;
	private String a;
	private String b;
	private transient String c;

	public SeriCtrol(String a, String b, String c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	// 此处是添加而不是“覆盖”或者“实现”
	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		stream.writeObject(b);
		// 默认情况下transient修饰的字段在反序列化时忽略，但我们可以手动控制
		stream.writeObject(c);
	}

	// 此处是添加而不是“覆盖”或者“实现”
	private void readObject(ObjectInputStream stream) throws IOException,
			ClassNotFoundException {
		stream.defaultReadObject();
		stream.readObject();
		// 此处将非瞬时变量设置为null了
		b = "null";
		c = (String) stream.readObject();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("非瞬时变量a:").append(a);
		sb.append("\n非瞬时变量b:").append(b);
		sb.append("\n瞬时变量c:").append(c);
		return sb.toString();
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		SeriCtrol sCtrol = new SeriCtrol("test1", "test2", "test3");
		System.out.println("创建的原始对象：");
		System.out.println(sCtrol);

		System.out.println("------开始序列化操作------------");
		ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutStream = new ObjectOutputStream(
				byteOutStream);
		objectOutStream.writeObject(sCtrol);

		System.out.println("------反序列化之后------------");
		ByteArrayInputStream byteInStream = new ByteArrayInputStream(
				byteOutStream.toByteArray());
		ObjectInputStream objectInStream = new ObjectInputStream(byteInStream);
		SeriCtrol sCtrolAnother = (SeriCtrol) objectInStream.readObject();
		System.out.println("反序列化后的对象（writeObject和readObject方法中对每个字段进行了精确控制）：");
		System.out.println(sCtrolAnother);

	}

}
