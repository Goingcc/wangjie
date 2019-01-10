package connectPackage.providerAndConsumer;

/**
 * @author wangjie
 * @data 2018/12/15 16:24
 * 消费者线程
 */
public class ThreadC extends Thread {
    private Consumer consumer;
    public ThreadC(Consumer consumer){
        super();
        this.consumer = consumer;
    }
    @Override
    public void run(){
        while (true){
            consumer.getValue();
        }
    }
}
