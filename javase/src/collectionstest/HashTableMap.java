package collectionstest;

import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashTableMap {

	public static void main(String[] args) {
		testNullHashtable();
		
		showHashTable();
		
		testNullHashMap();
		
		showHashMap();
		
	}

/**
 * HashMap遍历方式有两种，推荐使用entrySet方式
 * <br/>第一种:
　　Map map = new HashMap();
　　Iterator iter = map.entrySet().iterator();
　　while (iter.hasNext()) {
　　Map.Entry entry = (Map.Entry) iter.next();
　　Object key = entry.getKey();
　　Object val = entry.getValue();
　　}
　　效率高,以后一定要使用此种方式！
<br/>
第二种:
　　Map map = new HashMap();
　　Iterator iter = map.keySet().iterator();
　　while (iter.hasNext()) {
　　Object key = iter.next();
　　Object val = map.get(key);
　　}
　　效率低,以后尽量少使用！
 */
private static void showHashMap() {
		
	   HashMap<String, String> hashmap = new HashMap<String, String>();

		for (int i = 0; i < 1000000; i++) {

			hashmap.put("Key=" + i, "Val=" + i);

		}
		
		long start1 = Calendar.getInstance().getTimeInMillis();
		Iterator iterator = hashmap.keySet().iterator();
		while (iterator.hasNext()) {
			hashmap.get(iterator.next());
		}
		System.out.println("使用keyset方式耗时： ");
		System.out.println(Calendar.getInstance().getTimeInMillis() - start1);
		
		
		long start2 = Calendar.getInstance().getTimeInMillis();
		java.util.Iterator it = hashmap.entrySet().iterator();
		while (it.hasNext()) {
		java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
        // entry.getKey() 返回与此项对应的键
		// entry.getValue() 返回与此项对应的值
		entry.getValue();
		}
		System.out.println("使用entryset方式耗时： ");
		System.out.println(Calendar.getInstance().getTimeInMillis() - start2);
}
	/**
	 * HashMap中的key和value都可以为null
	 */
	private static void testNullHashMap() {
		HashMap hashmap = new HashMap();

		hashmap.put(null, "123");

		hashmap.put("1", null);
	}

	/**
	 * Hashtable中的key和value都不能为null
	 */
	private static void testNullHashtable() {
		Hashtable hashtable = new Hashtable();

		 //运行中会报空指针异常，获取hashcode时报空指针 key.hashCode()
		 hashtable.put(null, "123");

		//判断value为null，throw一个空指针异常
		hashtable.put("1", null);
	}
	
	

	/**
	 *  总结：通过迭代来遍历比枚举要多花尽一倍的时间。所以建议大家最好通过枚举类来遍历Hashtable哦。
	 */
	private static void showHashTable() {
		
		Hashtable<String, String> ht = new Hashtable<String, String>();

		for (int i = 0; i < 10000; i++) {

			ht.put("Key=" + i, "Val=" + i);

		}

		// 1. Enumeration

		long start = System.currentTimeMillis();

		Enumeration<String> en = ht.keys();

		while (en.hasMoreElements()) {

			en.nextElement();

		}

		long end = System.currentTimeMillis();

		System.out.println("Enumeration keys costs " + (end - start)
				+ " milliseconds");

		// 2. Enumeration

		start = System.currentTimeMillis();

		Enumeration<String> en2 = ht.elements();

		while (en2.hasMoreElements()) {

			en2.nextElement();

		}

		end = System.currentTimeMillis();

		System.out.println("Enumeration elements costs " + (end - start)
				+ " milliseconds");

		// 3. Iterator

		start = System.currentTimeMillis();

		Iterator<String> it = ht.keySet().iterator();

		while (it.hasNext()) {

			it.next();

		}

		end = System.currentTimeMillis();

		System.out.println("Iterator keySet costs " + (end - start)
				+ " milliseconds");

		// 4. Iterator

		start = System.currentTimeMillis();

		Iterator<Entry<String, String>> it2 = ht.entrySet().iterator();

		while (it2.hasNext()) {

			it2.next();

		}

		end = System.currentTimeMillis();
		System.out.println("Iterator entrySet costs " + (end - start)
				+ " milliseconds");
	}
}
