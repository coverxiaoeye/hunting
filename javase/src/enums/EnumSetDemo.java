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
	        // of()���������캬��ָ��Ԫ�ص�ö�ټ���
	        EnumSet<FontConstant> enumSet = EnumSet.of(FontConstant.Plain,
	                FontConstant.Bold);
	        showEnumSet(enumSet);

	        System.out.println("------------complementOf()---------------");
	        // complementOf()����������ָ��ö�ټ��ϵĲ���
	        showEnumSet(EnumSet.complementOf(enumSet));

	        System.out.println("--------------noneOf()-----------------");
	        // noneOf()��������һ��ָ��ö�����͵Ŀ�ö�ټ���
	        EnumSet<FontConstant> enumSet2 = EnumSet.noneOf(FontConstant.class);
	        enumSet2.add(FontConstant.Italic);
	        showEnumSet(enumSet2);

	        System.out.println("---------------copyOf()------------------");
	        // copyOf()������һ�����ؿ����ɼ��Ϲ���ö�ټ���

	        // �ȹ���һ��List
	        List<FontConstant> list = new ArrayList<FontConstant>();
	        list.add(FontConstant.Bold);
	        list.add(FontConstant.Italic);
	        list.add(FontConstant.Plain);
	        list.add(FontConstant.Bold);

	        // Ȼ��ʹ��copyO��������һ��EnumSet
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

