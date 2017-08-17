package javase.serializable;

import java.io.Serializable;
import java.util.Date;
/**
 * 用于测试序列化时是否是deep copy
 * @author wangyg
 *
 */
/*如果House类不实现Serializable接口，对animal进行序列化操作会报异常如下
  java.io.NotSerializableException: javase.serializable.House
*/
public class House implements Serializable{
	
	private static final long serialVersionUID = 7217638462888484150L;
	private String name;
	private Date date = new Date(); //记录当前时间


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		//此处super.toString()输出该对象的地址
		return "HouseNO:"+name+"|对象地址："+super.toString()+"|Create Time is:"+date;
	}
 }
