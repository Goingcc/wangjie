package dclpackage;

/**
 * @author wangjie
 * @data 2019/1/13 17:06
 * 创建线程类
 */
public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println(MyObject.getInstance().hashCode());
    }
}
