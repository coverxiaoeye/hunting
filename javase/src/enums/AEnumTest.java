package enums;

//使用enum关键字定义枚举类，此处Color就是枚举类，Red就是枚举类的一个对象
//所以此处不能添加public关键字，跟类定义一样
//public enum Color{
enum Color{
	Red,Greeen,BLUE
}

public class AEnumTest {

	public static void main(String[] args) {
		//说明：RED实际上就表示的是枚举的名称，默认的编号是0，可以使用ordinal()方法获得
		System.out.println(Color.Red.ordinal());

	}

}
