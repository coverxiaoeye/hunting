package collectionstest;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestLinkedHashMap {

	public static void main(String[] args) {
     Map<Integer,String> map = new LinkedHashMap<Integer,String>(6,0.75f,true);
     map.put(2, "2world");
     map.put(1, "1world");
     map.put(3, "3world");
     map.get(1);
     map.get(2);
 
     for (Entry<Integer,String> iter:map.entrySet()) {
		System.out.println(iter.getKey());
	}
	}

}
