package accessPermissionTest.first;

public class Father {

	public int public_int = 1;
	protected int protected_int = 1; 
	private int private_int = 1;
	int default_int = 1;
	
	
	public static void main(String[] args) {
		Father p = new Father();
		System.out.println("����ڲ���"
		        +p.public_int+"\t"
				+p.protected_int+"\t"
				+p.private_int+"\t"
				+p.default_int);
	}//����ڲ�ȫ�������Է���

}
