package overloadtest;

public class Director {

	public static void main(String[] args) {
		Show show1 = new Show();
		
		Cat cat1 = new Cat();
		show1.say(cat1, "dajiahao");
		
		System.out.println("--------------------");
		Animal animal1 = cat1;
		show1.say(animal1, "dajiahao");//print: "animal say:dajiahao",重载是编译时处理
	}

}
