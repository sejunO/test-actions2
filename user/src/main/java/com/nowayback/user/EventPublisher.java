package com.nowayback.user;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventPublisher {

    private final SqsTemplate sqsTemplate;

    public void publish(UserDto userDto) {
        sqsTemplate.send("user-updated-queue-to-project", userDto);
    }
}
