package com.library.librarystudent;

import com.library.librarystudent.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping("sendmessage")
    public String sendMessage(@RequestBody String message) throws ExecutionException, InterruptedException {

       return kafkaProducer.sendMessage(message);

    }
}
