package atomicPackage;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangjie
 * @data 2018/12/15 11:46
 * 使用原子类AtomicInteger同步实现i++
 */
public class AddCountThread extends Thread {
    private AtomicInteger count = new AtomicInteger(0);
    @Override
    public void run(){
        for (int i = 0; i <10000 ; i++) {
            //将当前值加1
            System.out.println(count.incrementAndGet());
        }
    }
}
