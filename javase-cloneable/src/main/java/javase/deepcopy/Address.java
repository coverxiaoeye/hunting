package javase.deepcopy;
/**
 * 未实现cloneable接口
 * @author wangyg
 *
 */
public class Address implements Cloneable{
	private String addr;

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	// 如果要实现深度复制，首先Address类要实现cloneable接口，并且修改clone方法
	@Override
	protected Object clone() {
		Address address = null;
		try {
			address = (Address)super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return address;
	}
	
}
