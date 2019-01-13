package dclpackage;

/**
 * @author wangjie
 * @data 2019/1/13 18:12
 * 使用静态内部类实现多线程环境下的单例模式
 */
public class MyObject3 {
    private static class MyObjectHandler{
        private static MyObject3 myObject3 = new MyObject3();
    }
    private MyObject3(){}
    public  static MyObject3 getInstance(){
        return MyObjectHandler.myObject3;
    }
}
