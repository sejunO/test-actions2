package com.nowayback.project;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EventListener {

    private final ProjectService projectService;

    @SqsListener("user-updated-queue-to-project")
    public void handleEvent(UserDto userDto) {
        log.info("Received user updated queue to {}", userDto);

        projectService.createProject(userDto.name(), "안녕 " + userDto.name());
    }
}
