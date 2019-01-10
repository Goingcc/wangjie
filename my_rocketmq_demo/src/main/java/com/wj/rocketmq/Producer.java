package com.wj.rocketmq;
import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * @author wangjie
 * @data 2019/1/10 17:47
 * 消息生产者
 */
public class Producer {

    public static void main(String[] args) {
        //1.创建一个生产者,需要指定Producer的分组，
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("Jony-P");
        //2.设置命名服务的地址,默认是去读取conf文件下的配置文件 rocketmq.namesrv.addr
        defaultMQProducer.setNamesrvAddr("127.0.0.1:9876");

        try{
            //3.启动生产者
            defaultMQProducer.start();
            for(int i=0;i<10;i++) {

                String text = "你好呀，ALIBABA----"+i;
                //4.最基本的生产模式 topic+文本信息
                Message msg = new Message("topic_orderCreate", "Tag-B", text.getBytes());
                //5.获取发送响应
                SendResult sendResult = defaultMQProducer.send(msg);

                System.out.println("###发送结果 result:" + JSON.toJSONString(sendResult));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //6.释放生产者
            defaultMQProducer.shutdown();
        }
    }
}
