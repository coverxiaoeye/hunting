package enums;

enum ColorDemo{
	/*
	 * 一旦定义有参数构造之后，在声明枚举对象的时候，就必须明确的调用构造方法，并进行传递参数.
	 * 否则提示找不到默认无参数的构造函数
	 */
	Red("红色"),Greeen("绿色"),BLUE("蓝色");
	
	/*
	 * 在枚举类中定义属性及自己的构造方法
	 */
	private String name;
	private ColorDemo(String name){
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
public class ConstructorEnum {

	public static void main(String[] args) {
		for (ColorDemo c : ColorDemo.values()) {
			/*
			 * 输出结果：
			 * 0--->Red(红色)
             * 1--->Greeen(绿色)
             * 2--->BLUE(蓝色)
			 */
			System.out.println(c.ordinal()+"--->"+c.name()+"("+c.getName()+")");
		}
		
		/*枚举默认实现了java.lang.Comparable接口
		 * 比较的基准是是两者在声明时的顺序，输出为-1， 0-1=-1
		 * self.ordinal - other.ordinal
		 */ 
		System.out.println(ColorDemo.Red.compareTo(ColorDemo.Greeen));


	}

}
