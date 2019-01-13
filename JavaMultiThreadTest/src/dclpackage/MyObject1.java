package dclpackage;

/**
 * @author wangjie
 * @data 2019/1/13 17:41
 */
public class MyObject1 {
    public static MyObject1 myObject1;
    private MyObject1(){}
    public static MyObject1 getInstance(){
        //延迟加载
        if(myObject1 != null){
        }else{
            myObject1 = new MyObject1();
        }
        return myObject1;
    }
}
