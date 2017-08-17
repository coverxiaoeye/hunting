/**
 * 
 */
package javase.proxy.cglib;

/**
 * @author wangyg
 *
 */
public class BookClient {

	public static void main(String[] args) {
	    BookFacadeCglib cglib=new BookFacadeCglib(); 
	    // cglib方式委托对象可以不实现接口，但jdk动态代理不行
        BookFacadeImpl bookCglib=(BookFacadeImpl)cglib.getInstance(new BookFacadeImpl());    
        bookCglib.addBook();    
	}
}
