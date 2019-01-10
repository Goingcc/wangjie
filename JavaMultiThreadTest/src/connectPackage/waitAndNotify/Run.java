package connectPackage.waitAndNotify;

/**
 * @author wangjie
 * @data 2018/12/15 15:24
 */
public class Run {
    public static void main(String[] args) {
        try{
            Object lock = new Object();
            ThreadA a = new ThreadA(lock);
            a.setName("A");
            a.start();
            Thread.sleep(50);
            ThreadB b = new ThreadB(lock);
            b.setName("B");
            b.start();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
