package collectionstest;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {

	public static void main(String[] args) {

		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println(list.size());
		list.add(4);
	}

}
