package com.wj.dubbo.systemb.pojo;

/**
 * @author wangjie
 * @data 2018/12/11 18:29.
 */
public class User implements java.io.Serializable{
    private static final long seriallizableID = -2668999087589887337L;
    private Long id;
    private String name;
    private String password;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
//    重写toString方法，便于输出结果
    public String toString() {
       return "id="+getId()+"  name="+getName()+
                "  age="+getAge()+"  password="+getPassword();
    }
}
