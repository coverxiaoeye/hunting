package javadoc;

/**
 * JAVA DOC��<b>Java Tag</b>��<b>HTML���</b>��ɡ�
 *
 * <br/>
 *
 * <h3>HTML���:</h3>
 * <ul>
 * <li>��������ע�͵ĸ�ʽ�������HTML��Ƕ�֧�֣����õ��С�</li>
 * <li>p������</li>
 * <li>br������</li>
 * <li>a��������</li>
 * <li>pre������Ԥ��ʽ�����ı�</li>
 * <li>b�����壬�� <b>����</b> <u>�»���</u></li>
 * <li>code: ����ı�ǣ�����ʽ�ϺͲ��ӱ���������֣���<code>String</code> </li>
 * <li>img��֧��ͼƬ��ǡ�<img src="http://img.alibaba.com/images/cms/upload/banner/partner_bigbuyer/70x25_goodyear.jpg"></li>
 * </ul>
 *
 * <h3>Java Tag:</h3>
 * <ul>
 * <li>Java Tag��������ע�͵����ԣ���@��ͷ��</li>
 * <li>@link�����ӵ������࣬��{@link JavaDocRuntimeException}</li>
 * <li>@see��Ϊ�˸����˽⵱ǰ�࣬����ȥ������������߷�����see��ǿ������ӵ��࣬������URL��ַ�ȡ�</li>
 * <li>@value�����ӵ�������1.4�Ժ��tag,�� {@value #SCRIPT_START}��סctrl+������������ӵ�SCRIPT_START����</li>
 * <li>@code����code�����ʹ�������ַ������ŵȣ�1.5���tag,�磺<pre>{@code List<String> users=new ArrayList<String>;}</pre></li>
 * </ul>
 *
 * @author tengfei.fangtf
 * @version �汾 1.0
 *
 * @see "javadoc.html"
 * @see <a href="spec.html#section">Java Spec</a>
 * @see String#equals(Object) equals
 * @see <a href="http://download.oracle.com/javase/1.5.0/docs/tooldocs/windows/javadoc.html">JavaDoc</a>
 *
 */
public class JavaDocDemo {

    public static final String SCRIPT_START = "<script>";

	/**
	 * ��������
	 *
	 * @param doc
	 *            ����˵��
	 * @return ����ֵ˵��
	 * @throws JavaDocRuntimeException
	 *             �÷������ܻ��׳����쳣���磺�������ĵ�ʧ��ʱ���׳�JavaDocRuntimeException�쳣
	 */
	public String genJavaDoc(String doc) {
		try {

		} catch (Exception e) {
			throw new JavaDocRuntimeException("����javaDOCʧ��");
		}
		return null;
	}

	/**
	 * @deprecated ��ʾ��ǰ�����Ѿ����Ƽ�ʹ�ã������·���ȡ����
	 */
	public String genJavaDoc(String doc, String type) {
		return null;

	}

	/**
	 * JAVA doc����ʱ�쳣
	 *
	 * @author tengfei.fangtf
	 *
	 */
	class JavaDocRuntimeException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public JavaDocRuntimeException(String string) {
		// TODO �������񣬱�ʾ��ǰ����ʱ����߼���ԭ���ܽ�������⣬������Eclipse��tasks��ͼ�²鿴
		}
	}

}