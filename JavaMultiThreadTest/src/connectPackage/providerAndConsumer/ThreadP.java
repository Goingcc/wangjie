package connectPackage.providerAndConsumer;

/**
 * @author wangjie
 * @data 2018/12/15 16:22
 * 生产者线程
 */
public class ThreadP extends Thread{
    private Provider provider;
    public ThreadP(Provider provider){
        super();
        this.provider = provider;
    }
    @Override
    public void run(){
        while(true){
            provider.setValue();
        }
    }
}
