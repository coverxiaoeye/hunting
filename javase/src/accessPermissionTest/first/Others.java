/**
 * 
 */
package accessPermissionTest.first;

/**
 * @author wangyg
 *
 */
public class Others{

	public static void main(String[] args) {
		Father p = new Father();
		System.out.println("同包下其他类："
		        +p.public_int+"\t"
				+p.protected_int+"\t"
				+p.private_int+"\t"
				+p.default_int);
	}//同包下其他类无法访问Father的private变量，但可以访问其protected变量

}
