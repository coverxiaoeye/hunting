package overridetest;

public class Director {

	public static void main(String[] args) {
		Cat cat1 = new Cat();
		cat1.say("dajiahao");
		
		System.out.println("--------------------");
		
		Animal animal = cat1;
		animal.say("dajiahao");//print:"cat say:dajiahao" 重写是运行时处理
	}

}