package com.example.rocketmqconsumer.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author N 2019/11/03 10:46
 */
@Component
@RocketMQMessageListener(topic = "nichuan-topic",consumerGroup = "consumer-group2",consumeThreadMax = 6)
public class NichuanTopicConsumer implements RocketMQListener<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NichuanTopicConsumer.class);
    @Override
    public void onMessage(String s) {
        LOGGER.info("接收到消息：{}",s);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("处理完成：{}",s);
    }
}
