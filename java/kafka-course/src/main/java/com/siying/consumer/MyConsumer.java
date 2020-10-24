package com.siying.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class MyConsumer {
    public static void main(String[] args) {
        //1. 创建消费者配置信息
        Properties properties = new Properties();

        //2. 给配置信息赋值
        // 连接的集群
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        // 开启自动提交offset
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, true);
        // 自动提交的延迟，默认是1000ms
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        // Key，Value的反序列化类
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        // 消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "bigdata");

        //3. 创建消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        //4. 订阅主题
        consumer.subscribe(Arrays.asList("first", "third"));

        //5. 获取数据，100ms
        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);

            //6. 解析并打印ConsumerRecords
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println(consumerRecord.key() + "--" + consumerRecord.value());
            }
        }

        // 关闭连接（consumer不需要关闭，上面写了一个死循环）
        // consumer.close();
    }
}
