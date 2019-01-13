package dclpackage;

/**
 * @author wangjie
 * @data 2019/1/13 18:19
 */
public class Run3 {
    public static void main(String[] args) {
        MyThread3 t1 = new MyThread3();
        MyThread3 t2 = new MyThread3();
        MyThread3 t3 = new MyThread3();
        t1.start();
        t2.start();
        t3.start();
    }
}
