package volatilePackage;

/**
 * @author wangjie
 * @data 2018/12/15 10:49
 * 测试volatile关键字
 */
public class PrintString implements Runnable{
    private boolean isContinuePrint = true;
    public boolean isContinuePrint(){
        return isContinuePrint;
    }
    public void setContinuePrint(boolean isContinuePrint){
        this.isContinuePrint = isContinuePrint;
    }

    public void printStringMethod(){
        try{
            while (isContinuePrint == true){
                System.out.println("run printStringMethod threadName = "+ Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        printStringMethod();
    }
}
