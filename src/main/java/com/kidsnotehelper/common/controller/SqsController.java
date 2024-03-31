package com.kidsnotehelper.common.controller;

import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@RestController
@RequestMapping("/sqs")
@RequiredArgsConstructor
public class SqsController {

    private final SqsAsyncClient sqsAsyncClient;

    @PostMapping
    public SendResult<String> send(@RequestBody String message) {
        SqsTemplate template = SqsTemplate.newTemplate(sqsAsyncClient);

        return template.send(to -> to.queue("DemoQueue")
                        .payload(message)
                // .header("myHeaderName", "myHeaderValue")
                // .headers(Map.of("myOtherHeaderName", "myOtherHeaderValue"))
                // .delaySeconds(10)
        );
    }
}
