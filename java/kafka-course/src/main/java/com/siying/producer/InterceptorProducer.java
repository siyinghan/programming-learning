package com.siying.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.Properties;

public class InterceptorProducer {
    public static void main(String[] args) {
        //1. 创建Kafka生产者的配置信息
        Properties properties = new Properties();

        //2. 指定连接的Kafka集群，broker-list
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        //3. ACK应答级别
        properties.put(ProducerConfig.ACKS_CONFIG, "all");

        //4. 重试次数
        properties.put("retries", 3);

        //5. 批次大小，一次发送多大数据，单位是字节
        properties.put("batch.size", 16384);

        //6. 等待时间，默认是1毫秒（和上面一起到16k发送或者到1毫秒发送）
        properties.put("linger.ms", 1);

        //7. RecordAccumulator缓冲区大小，32M（和上面的16k不是一个东西，到了16k写入这里，这里最大32M）
        properties.put("buffer.memory", 33554432);

        //8. Key，Value的序列化类
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //添加拦截器
        ArrayList<String> interceptors = new ArrayList<>();
        interceptors.add("com.siying.interceptor.TimeInterceptor");
        interceptors.add("com.siying.interceptor.CounterInceptor");
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);

        //9. 创建生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        //10. 发送数据
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>("first", "siying", "siying--" + i));
        }

        System.out.println("sdfsdf");

        //11. 关闭资源
        producer.close();
    }
}