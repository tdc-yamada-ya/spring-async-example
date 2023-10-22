package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MyComponent {
    private static final Logger logger = LoggerFactory.getLogger(MyComponent.class);

    @Async
    public void createUsers(int count) {
        for (int i = 0; i < count; i ++) {
            logger.trace("i: {}", i);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
