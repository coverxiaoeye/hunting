package enums;

//ʹ��enum�ؼ��ֶ���ö���࣬�˴�Color����ö���࣬Red����ö�����һ������
//���Դ˴��������public�ؼ��֣����ඨ��һ��
//public enum Color{
enum Color{
	Red,Greeen,BLUE
}

public class AEnumTest {

	public static void main(String[] args) {
		//˵����REDʵ���Ͼͱ�ʾ����ö�ٵ����ƣ�Ĭ�ϵı����0������ʹ��ordinal()�������
		System.out.println(Color.Red.ordinal());

	}

}
