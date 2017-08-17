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
 * HashMap������ʽ�����֣��Ƽ�ʹ��entrySet��ʽ
 * <br/>��һ��:
����Map map = new HashMap();
����Iterator iter = map.entrySet().iterator();
����while (iter.hasNext()) {
����Map.Entry entry = (Map.Entry) iter.next();
����Object key = entry.getKey();
����Object val = entry.getValue();
����}
����Ч�ʸ�,�Ժ�һ��Ҫʹ�ô��ַ�ʽ��
<br/>
�ڶ���:
����Map map = new HashMap();
����Iterator iter = map.keySet().iterator();
����while (iter.hasNext()) {
����Object key = iter.next();
����Object val = map.get(key);
����}
����Ч�ʵ�,�Ժ�����ʹ�ã�
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
		System.out.println("ʹ��keyset��ʽ��ʱ�� ");
		System.out.println(Calendar.getInstance().getTimeInMillis() - start1);
		
		
		long start2 = Calendar.getInstance().getTimeInMillis();
		java.util.Iterator it = hashmap.entrySet().iterator();
		while (it.hasNext()) {
		java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
        // entry.getKey() ����������Ӧ�ļ�
		// entry.getValue() ����������Ӧ��ֵ
		entry.getValue();
		}
		System.out.println("ʹ��entryset��ʽ��ʱ�� ");
		System.out.println(Calendar.getInstance().getTimeInMillis() - start2);
}
	/**
	 * HashMap�е�key��value������Ϊnull
	 */
	private static void testNullHashMap() {
		HashMap hashmap = new HashMap();

		hashmap.put(null, "123");

		hashmap.put("1", null);
	}

	/**
	 * Hashtable�е�key��value������Ϊnull
	 */
	private static void testNullHashtable() {
		Hashtable hashtable = new Hashtable();

		 //�����лᱨ��ָ���쳣����ȡhashcodeʱ����ָ�� key.hashCode()
		 hashtable.put(null, "123");

		//�ж�valueΪnull��throwһ����ָ���쳣
		hashtable.put("1", null);
	}
	
	

	/**
	 *  �ܽ᣺ͨ��������������ö��Ҫ�໨��һ����ʱ�䡣���Խ��������ͨ��ö����������HashtableŶ��
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
