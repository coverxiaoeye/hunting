package overloadtest;

public class Show {

	public void say(Animal animal,String content){
		System.out.println("animal say:"+content);
	}
	public void say(Cat cat,String content){
		System.out.println("cat say:"+content);
	}
}
