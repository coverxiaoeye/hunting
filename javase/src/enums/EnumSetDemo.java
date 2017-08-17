package enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;


	enum FontConstant
	{
	    Plain, Bold, Italic, Hello,
	}

	public class EnumSetDemo
	{

	    public static void main(String[] args)
	    {
	        System.out.println("--------------of()-----------------");
	        // of()方法，构造含有指定元素的枚举集合
	        EnumSet<FontConstant> enumSet = EnumSet.of(FontConstant.Plain,
	                FontConstant.Bold);
	        showEnumSet(enumSet);

	        System.out.println("------------complementOf()---------------");
	        // complementOf()方法，构造指定枚举集合的补集
	        showEnumSet(EnumSet.complementOf(enumSet));

	        System.out.println("--------------noneOf()-----------------");
	        // noneOf()方法构造一个指定枚举类型的空枚举集合
	        EnumSet<FontConstant> enumSet2 = EnumSet.noneOf(FontConstant.class);
	        enumSet2.add(FontConstant.Italic);
	        showEnumSet(enumSet2);

	        System.out.println("---------------copyOf()------------------");
	        // copyOf()方法的一种重载可以由集合构造枚举集合

	        // 先构造一个List
	        List<FontConstant> list = new ArrayList<FontConstant>();
	        list.add(FontConstant.Bold);
	        list.add(FontConstant.Italic);
	        list.add(FontConstant.Plain);
	        list.add(FontConstant.Bold);

	        // 然后使用copyO方法构造一个EnumSet
	        showEnumSet(EnumSet.copyOf(list));

	    }

	    public static void showEnumSet(EnumSet<FontConstant> enumSet)
	    {
	        for (Iterator<FontConstant> iter = enumSet.iterator(); iter.hasNext();)
	        {
	            System.out.println(iter.next());
	        }
	    }
	}

