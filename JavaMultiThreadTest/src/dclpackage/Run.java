package dclpackage;

/**
 * @author wangjie
 * @data 2019/1/13 17:07
 * 线程运行类
 */
public class Run {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
