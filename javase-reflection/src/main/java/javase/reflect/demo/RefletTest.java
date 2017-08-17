package javase.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefletTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		// 反射例子1
		System.out.println("==========反射例子之1==========");
		Class<Role> cls1 = Role.class;
		// 只能反射默认的构造函数
		Role role1 = cls1.newInstance();
		role1.toString();

		// 反射例子2
		System.out.println("==========反射例子之2==========");
		Class<Role> cls2 = ((Class<Role>) Class
				.forName("javase.reflect.demo.Role"));
		// 只能反射默认的构造函数
		Role role2 = cls2.newInstance();
		role2.toString();

		// 反射的例子3 获取类的构造器
		/**
		 * public Constructor<?>[] getConstructors()
		 * 返回类中所有的public构造器集合，默认构造器的下标为0 public Constructor<T>
		 * getConstructor(Class<?>... parameterTypes) 返回指定public构造器，参数为构造器参数类型集合
		 * 
		 * public Constructor<?>[] getDeclaredConstructors() 返回类中所有的构造器，包括私有
		 * public Constructor<T>
		 * getDeclaredConstructor(Class<?>...parameterTypes) 返回任意指定的构造器
		 */
		System.out.println("==========反射例子之3==========");
		Constructor<Role>[] construnctors = (Constructor<Role>[]) cls2
				.getConstructors();
		System.out.println("getConstructors()得到的public构造器个数："
				+ construnctors.length);

		Constructor<Role>[] construnctors2 = (Constructor<Role>[]) cls2
				.getDeclaredConstructors();
		System.out.println("getDeclaredConstructors()得到的public构造器个数："
				+ construnctors2.length);

		try {
			Constructor<Role> constructor1 = cls2
					.getConstructor(new Class[] { String.class });
			Role role3 = constructor1.newInstance("public型的带参数的");
			role3.toString();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 反射的例子4 获取private的类构造器
		System.out.println("==========反射例子之4==========");
		Constructor<Role> constructor2;
		Role role4 = null;
		try {
			//只能使用getDeclaredConstructor方法，而不能使用getConstructor（如果使用会抛出异常java.lang.NoSuchMethodException）
			constructor2 = cls2.getDeclaredConstructor(new Class[] {
					String.class, String.class });
			// 设置访问权限，私有时必须设,否则抛出“java.lang.IllegalAccessException”异常
			constructor2.setAccessible(true);
			role4 = constructor2.newInstance("带参数的", "private型的");
			role4.toString();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 反射例子5 获取类的成员变量
        /** 
         * 了解了构造器，其实你可以猜到成员变量的获取方法了，成员变量用Field类进行封装。 
         * 主要的方法非常的类似： 
         * public Field getDeclaredField(String name) 获取任意指定名字的成员 
         * public Field[] getDeclaredFields() 获取所有的成员变量
         * public Field getField(String name) 获取任意public成员变量
         * public Field[] getFields() 获取所有的public成员变量
         */
		try {
			Field field1 = cls2.getDeclaredField("type");
			field1.setAccessible(true);
			Object object1 = field1.get(role2);//参数是实例化的类
			Object object2 = field1.get(role4);
			System.out.println("=========反射例子之5===========");
			System.out.println("role2的type字段："+object1);			
			System.out.println("role4的type字段："+object2);			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 反射例子6 方法 --方法
        /**
         * public Method[] getMethods() 获取所有的公有方法的集合 
         * public Method getMethod(String name,Class<?>... parameterTypes) 
         * 获取指定公有方法 参数1：方法名 参数2：参数类型集合 
         * public Method[] getDeclaredMethods() 获取所有的方法 
         * public Method getDeclaredMethod(String name,Class<?>... parameterTypes) 
         * 获取任意指定方法,无参的时候我们只要传null就行了。
         */
		try {
			//getDeclaredMethods()的第二个参数是可变参数，可以直接罗列参数对应的class，也可新建Class数组
			//Method method1 = cls2.getDeclaredMethod("setName", String.class);
			Method method1 = cls2.getDeclaredMethod("setName", new Class[]{String.class});
			method1.setAccessible(true);
			method1.invoke(role2, "私有的我也可以用");
			//当方法没有参数时，第2个参数可以直接不些
			//Method method2 = cls2.getMethod("getName");
			Method method2 = cls2.getMethod("getName", null);
			//方法反射调用时，如果方法没有参数，参数列表可以不写
			//Object result = method2.invoke(role2);
			Object result = method2.invoke(role2, null);//非静态方法第一个参数不能为null,应该是实例化的类
			System.out.println("=========反射例子之6===========");
			System.out.println("通过反射调用setName/getName得到的name是："+result);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 反射例子7 方法 --静态方法和字段，
		Method method3; 
		System.out.println("=========反射例子之7===========");
		try {
			method3 = cls2.getMethod("getInstance",null);
			Object result = method3.invoke(null, null);//记住与普通方法不同，第一个参数可以为null
			if(result instanceof Role){
				System.out.println("通过反射调用静态方法实例化成功");
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//内部类神马的 ---后续加上
	}

}
