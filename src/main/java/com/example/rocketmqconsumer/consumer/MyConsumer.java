package com.example.rocketmqconsumer.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author N 2019/11/02 15:10
 */
@Component
@RocketMQMessageListener(topic = "topic-A",consumerGroup = "consumer-group1",consumeThreadMax = 1)
public class MyConsumer implements RocketMQListener<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyConsumer.class);
    @Override
    public void onMessage(String s) {
        LOGGER.info("接收到消息：{}",s);
        try {
            Thread.sleep(10000);
            LOGGER.info("处理完消息:{}",s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
