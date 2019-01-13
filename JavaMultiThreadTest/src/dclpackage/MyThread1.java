package dclpackage;

/**
 * @author wangjie
 * @data 2019/1/13 17:45
 */
public class MyThread1 extends Thread{
    @Override
    public void run(){
        System.out.println(MyObject1.getInstance().hashCode());
    }
}
