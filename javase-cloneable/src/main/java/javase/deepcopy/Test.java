package javase.deepcopy;

public class Test {

	public static void main(String[] args) {
		Address addr = new Address();
		addr.setAddr("沙坪坝区石河子路");
		Student stu1 = new Student();
		stu1.setNum(10001);
		stu1.setName("学生1");
		//学生的以下信息都一致
		stu1.setSchool("chongqingdaxue");
		stu1.setTeacher("张季华教授");
		stu1.setAddress(addr);
		
		Student stu2 = (Student) stu1.clone();
		
		System.out.println("clone后两个对象：");
		// clone得到的对象与原对象地址引用不相等，说明两个对象不是同一个，重新建立了一个
		System.out.print("stu1==stu2的值：");
		System.out.println(stu1==stu2);
		System.out.println(stu1);
		System.out.println(stu2);
		
		// 这里只是简单示例，clone的典型场景是对象大部分信息都不需要修改，
		//比如通信地址、班级、学校都不变，只是修改学号姓名罢了
		stu2.setNum(10002);
		stu2.setName("学生2");
		//stu2是走读的
	    //由于此处是深度复制了。真正的开辟了另一块空间，将值复制后再将引用返回给新对象
		stu2.getAddress().setAddr("沙坪坝区北城天街");
		System.out.println("对克隆后的对象进行修改后：");
		System.out.println(stu1);
		System.out.println(stu2);
	}

}
