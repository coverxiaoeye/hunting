package javase.reflect.demo;

/**
 * 用于反射的类
*/

public class Role {
    
    private String name = "默认的不带参数的构造函数";
    
    private String type ="默认是public";
    
    private static Role instance  = null;
    
    
    //不带参数的
    public Role() {
    }
    
    //带参数的
    public Role(String name) {
        this.name = name;
    }
    
    //私有带参数的构造函数
    private Role(String name,String type) {
        this.name = name;
        this.type = type;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        System.out.println(getName()+":"+getType());
        return this.getName();
    }
    
    public synchronized static Role getInstance() {
        if(instance == null) {
            instance = new Role("带参数的","俺是private");
        }
        return instance;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }
 }
