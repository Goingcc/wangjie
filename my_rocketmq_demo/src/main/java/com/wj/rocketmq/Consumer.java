package com.wj.rocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import java.util.Date;
import java.util.List;

/**
 * @author wangjie
 * @data 2019/1/10 17:50
 */
public class Consumer {

    public static void main(String[] args) {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("Consumer-g");

        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        try {
            //第二个参数表示消费匹配的tag * 表示topic所有的tag
            consumer.subscribe("topic_orderCreate","Tag-B");

            //2. 注册消费者监听
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                /**
                 * msgs 表示消息体
                 * @param msgs
                 * @param context
                 * @return
                 */
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    for(MessageExt messageExt:msgs){
                        try {
                            System.out.println(new Date()+new String(messageExt.getBody(),"UTF-8"));
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            //3.consumer 启动
            consumer.start();
            System.out.println("消费端起来了哈.........");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
