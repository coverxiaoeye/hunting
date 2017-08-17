package javase.externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Blip implements Externalizable {

	private int i;
	
	private String s; //默认没有初始化
	
	public Blip() {
		/*
		 * 默认构造函数必须有，而且必须是public
		 * 否则在反序列化时要调用无参数构造函数找不到，
		 * 报异常"java.io.InvalidClassException: javase.externalizable.Blip; javase.externalizable.Blip; no valid constructor"
		 */
		System.out.println("Blip的默认无参数构造函数");
	}
	
	public Blip(String s,int i){
		//s,i只是在带参数的构造函数中进行初始化
		System.out.println("Blip带参数的构造函数");
		this.s =s;
		this.i =i;
	}
	
	@Override
	public String toString() {
		return s+i;
	}
	
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("调用writeExternal()方法");
		//如果我们不将s和i的值写入的话，那么在反序列化的时候，就不会得到这些值
		out.writeObject(s);
		out.writeInt(i);
		

	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("调用readExternal()方法");
		//在反序列化时，需要初始化s和i，否则只是调用默认构造函数，得不到s和i的值。s对应默认初始值null，i为0
		//s=(String)in.readObject();
		//i=in.readInt();

	}

}
