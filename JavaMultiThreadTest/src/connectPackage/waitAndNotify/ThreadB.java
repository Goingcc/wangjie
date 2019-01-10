package connectPackage.waitAndNotify;

/**
 * @author wangjie
 * @data 2018/12/15 15:19
 * notify()被调用后，当前线程并不会立即释放锁，而是继续执行完后菜释放，继而执行wait（)的线程
 */
public class ThreadB extends Thread {
    private Object lock;
    public ThreadB(Object lock){
        super();
        this.lock = lock;
    }
    @Override
    public void run(){
        try{
            synchronized(lock){
                for (int i = 0; i <10 ; i++) {
                    MyList.add();
                    if(MyList.size() == 5){
                        lock.notify();
                        System.out.println("notify()已发出通知！");
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"  添加了"+ (i+1) + "个元素！");
                    Thread.sleep(1000);
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
