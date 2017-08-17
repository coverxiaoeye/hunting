/**
 * 
 */
package javase.shallowcopy;

/**
 * @author wangyg
 *
 */
public class Student implements Cloneable{
	
	private int num;
	private String name;
	private String school;
	private Address address;
	private String teacher;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		StringBuilder stringpool = new StringBuilder();
		stringpool.append(this.getName());
		stringpool.append(":");
		stringpool.append(this.getNum()).append("|");
		stringpool.append(this.getSchool()).append("|");
		stringpool.append(this.getTeacher()).append("|");
		stringpool.append(this.getAddress().getAddr());
		return stringpool.toString();
	}
	@Override
	/**
	 * 典型的调用clone()代码
	 */
	protected Object clone() {
		Student stu = null;
		try {
			stu = (Student)super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return stu;
	}
	

}
