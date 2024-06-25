package com.library.librarystudent.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.librarystudent.model.KafkaStudent;
import com.library.librarystudent.model.Student;
import com.library.librarystudent.service.StudentService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
   StudentService studentService;

    @KafkaListener(topics = "myFirstTopic",groupId = "library")
    public void consumer(ConsumerRecord<String,String> record){
      String payloadData= record.value();

      ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode=mapper.readTree(payloadData);
            KafkaStudent kStudent=mapper.convertValue(jsonNode, KafkaStudent.class);
            studentService.insertStudent(kStudent);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
