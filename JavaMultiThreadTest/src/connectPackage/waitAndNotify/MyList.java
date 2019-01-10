package connectPackage.waitAndNotify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjie
 * @data 2018/12/15 15:12
 * 测试notify（）和wait（）方法实现线程间通信
 */
public class MyList {
    private static List list = new ArrayList();
    public static void add(){
        list.add("wangjie");
    }
    public static int size(){
        return list.size();
    }
}
