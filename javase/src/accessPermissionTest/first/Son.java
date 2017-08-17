/**
 * 
 */
package accessPermissionTest.first;

/**
 * @author wangyg
 *
 */
public class Son extends Father {

	public static void main(String[] args) {
		Father p = new Father();
		System.out.println("同包下子类："
		        +p.public_int+"\t"
				+p.protected_int+"\t"
				+p.private_int+"\t"
				+p.default_int);
	}//同包下子类无法访问父类的private变量

}
