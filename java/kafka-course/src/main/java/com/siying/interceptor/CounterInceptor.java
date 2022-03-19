package com.siying.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class CounterInceptor implements ProducerInterceptor<String, String> {

    int success;
    int error;

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        // 这里只需要把null修改为producerRecord，不用写其他的（null相当于是个过滤器）
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if (recordMetadata != null) {
            success++;
        } else {
            error++;
        }
    }

    @Override
    public void close() {
        System.out.println("success: " + success);
        System.out.println("error: " + error);
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
