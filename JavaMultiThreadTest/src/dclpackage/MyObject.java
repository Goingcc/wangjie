package dclpackage;

/**
 * @author wangjie
 * @data 2019/1/13 17:01
 * 使用DCL双检测锁机制实现单利模式（懒汉模式）
 */
public class MyObject {
    private volatile static MyObject myObject;
    private MyObject(){

    }
    public static MyObject getInstance(){
        try{
            if(myObject != null){

            }else{
                Thread.sleep(3000);
                synchronized (MyObject.class){
                    if(myObject == null){
                        myObject = new MyObject();
                    }
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return myObject;
    }
}
