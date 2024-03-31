package com.kidsnotehelper;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KidsnoteHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(KidsnoteHelperApplication.class, args);
    }


    @SqsListener("DemoQueue")
    public void listen(String message) {
        System.out.println(message);

        /**
         * Consumer에서는 process, ACK, NACK 처리를 해주어야한다.
         */
    }
}
