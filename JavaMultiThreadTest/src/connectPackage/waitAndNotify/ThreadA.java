package connectPackage.waitAndNotify;

/**
 * @author wangjie
 * @data 2018/12/15 15:15
 */
public class ThreadA extends Thread {
    private Object lock;
    public ThreadA(Object lock){
        super();
        this.lock = lock;
    }
    @Override
    public void run(){
        try{
            synchronized(lock){
                if(MyList.size() != 5){
                    System.out.println("线程"+Thread.currentThread().getName()+"  wait begin  " + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("线程"+Thread.currentThread().getName()+"  wait end  " + System.currentTimeMillis());
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
