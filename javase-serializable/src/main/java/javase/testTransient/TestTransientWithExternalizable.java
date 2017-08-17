package javase.testTransient;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 由于Externalizable对象在默认情况下不保存它的任何字段（即任何字段都不进行序列化处理），
 * 所以理论上transient关键字只能和Serializable对象一起使用。
 * 
 * 当然非要跟Externalizable一起用也没问题，默认情况下所有的都是null，不管是不是transient
 * @author wangyg
 *
 */
public class TestTransientWithExternalizable implements Externalizable {

	private String a;
	private String b;
	// 默认情况下transient修饰的字段在反序列化时忽略，这里c就为null
	private transient String c;
	
	public TestTransientWithExternalizable() {
		// TODO Auto-generated constructor stub
	}
	 public TestTransientWithExternalizable(String a,String b,String c) {
	        this.a =  a;
	        this.b =  b;
	        this.c =  c;
	    }
	 
//	 private void writeObject(ObjectOutputStream stream) throws IOException{
//			stream.defaultWriteObject();
//	}
//     private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
//			 stream.defaultReadObject();
//	}
	 
	 public String toString(){
		 StringBuilder sb = new StringBuilder();
		 sb.append("非瞬时变量a:").append(a);
		 sb.append("\n非瞬时变量b:").append(b);
		 sb.append("\n瞬时变量c:").append(c);
		 return sb.toString();
	 }
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		TestTransientWithExternalizable sCtrol = new TestTransientWithExternalizable("test1", "test2", "test3");
		System.out.println("创建的原始对象：");
		System.out.println(sCtrol);
		
		System.out.println("------开始序列化操作------------");
		ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutStream = new ObjectOutputStream(byteOutStream);
		objectOutStream.writeObject(sCtrol);
		
		System.out.println("------反序列化之后------------");
		ByteArrayInputStream byteInStream = new ByteArrayInputStream(byteOutStream.toByteArray());
		ObjectInputStream objectInStream = new ObjectInputStream(byteInStream);
		TestTransientWithExternalizable sCtrolAnother = (TestTransientWithExternalizable)objectInStream.readObject();
		System.out.println("反序列化后的对象：");
		System.out.println(sCtrolAnother);

	}

	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
