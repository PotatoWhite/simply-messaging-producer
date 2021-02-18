package io.easywalk.simplymessagingproducer;

import io.easywalk.simply.eventable.kafka.producer.EnableSimplyProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableSimplyProducer
@SpringBootApplication
public class SimplyMessagingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplyMessagingApplication.class, args);
    }

}
