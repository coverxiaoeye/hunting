/**
 * 
 */
package accessPermissionTest.firstnew;

import accessPermissionTest.first.Father;

/**
 * @author wangyg
 *
 */
public class Son extends Father {

	public static void main(String[] args) {
		Father p = new Father();
		System.out.println("不同包下子类："
		        +p.public_int+"\t"
				+p.protected_int+"\t"
				+p.private_int+"\t"
				+p.default_int);
	}//不同包下子类无法访问private变量、protected变量和默认权限变量
}
