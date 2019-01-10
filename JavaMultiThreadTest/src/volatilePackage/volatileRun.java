package volatilePackage;

/**
 * @author wangjie
 * @data 2018/12/15 10:55
 */
public class volatileRun  {
    public static void main(String[] args) {
        PrintString printString = new PrintString();
        new Thread(printString).start();
        System.out.println("我要停止它! stopThread="+Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }
}
