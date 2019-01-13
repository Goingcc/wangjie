package dclpackage;
/**
 * @author wangjie
 * @data 2019/1/13 18:15
 */
public class MyThread3 extends Thread {
    @Override
    public void run(){
        System.out.println(MyObject3.getInstance().hashCode());
    }
}
