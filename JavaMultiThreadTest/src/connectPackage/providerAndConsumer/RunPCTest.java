package connectPackage.providerAndConsumer;

import java.util.List;

/**
 * @author wangjie
 * @data 2018/12/15 16:26
 */
public class RunPCTest {
    public static void main(String[] args) {
        String lock = new String("");
        Provider provider = new Provider(lock);
        Consumer consumer = new Consumer(lock);
        ThreadP threadP = new ThreadP(provider);
        ThreadC threadC = new ThreadC(consumer);
        threadP.start();
        threadC.start();
    }
}
