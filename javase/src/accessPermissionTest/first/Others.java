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
		System.out.println("ͬ���������ࣺ"
		        +p.public_int+"\t"
				+p.protected_int+"\t"
				+p.private_int+"\t"
				+p.default_int);
	}//ͬ�����������޷�����Father��private�����������Է�����protected����

}
