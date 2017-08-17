package javase.serializable;

import java.io.Serializable;

public class Animal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1808480946257848572L;

	private String name;
	
	private House house;
	
	public Animal(String name,House house) {
		this.name = name;
		this.house = house;
		System.out.println("调用了Animal构造器");
	}
	
	@Override
	public String toString() {
		//此处super.toString()输出该对象的地址
		return name + "对象地址：[" + super.toString()+"] || "+house;
	}
}
