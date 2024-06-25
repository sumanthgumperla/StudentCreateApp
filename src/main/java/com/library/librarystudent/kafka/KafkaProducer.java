package com.library.librarystudent.kafka;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org. springframework. kafka. support. SendResult;

@Component
public class KafkaProducer {

    public static final String TOPIC_NAME = "myFirstTopic";

    KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(String message) throws ExecutionException, InterruptedException {

        String output="";
         CompletableFuture<SendResult<String, String>>  response=kafkaTemplate.send(TOPIC_NAME, message);
          SendResult<String, String> responseResult=response.get();
         RecordMetadata metaData= responseResult.getRecordMetadata();
         Integer partition = metaData.partition();
         Long offset = metaData.offset();
        System.out.println(partition);
        System.out.println(offset);
        output.concat(String.valueOf(partition)).concat(" ").concat(String.valueOf(offset));
        System.out.println(output);
        return output;
    }


}
