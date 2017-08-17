package enums;

enum ColorDemo{
	/*
	 * һ�������в�������֮��������ö�ٶ����ʱ�򣬾ͱ�����ȷ�ĵ��ù��췽���������д��ݲ���.
	 * ������ʾ�Ҳ���Ĭ���޲����Ĺ��캯��
	 */
	Red("��ɫ"),Greeen("��ɫ"),BLUE("��ɫ");
	
	/*
	 * ��ö�����ж������Լ��Լ��Ĺ��췽��
	 */
	private String name;
	private ColorDemo(String name){
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
public class ConstructorEnum {

	public static void main(String[] args) {
		for (ColorDemo c : ColorDemo.values()) {
			/*
			 * ��������
			 * 0--->Red(��ɫ)
             * 1--->Greeen(��ɫ)
             * 2--->BLUE(��ɫ)
			 */
			System.out.println(c.ordinal()+"--->"+c.name()+"("+c.getName()+")");
		}
		
		/*ö��Ĭ��ʵ����java.lang.Comparable�ӿ�
		 * �ȽϵĻ�׼��������������ʱ��˳�����Ϊ-1�� 0-1=-1
		 * self.ordinal - other.ordinal
		 */ 
		System.out.println(ColorDemo.Red.compareTo(ColorDemo.Greeen));


	}

}
