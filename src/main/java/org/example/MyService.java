package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MyService {
    private static final Logger logger = LoggerFactory.getLogger(MyComponent.class);

    private final MyComponent myComponent;

    @Autowired
    public MyService(MyComponent myComponent) {
        this.myComponent = myComponent;
    }

    public void createUsers(int count) {
        myComponent.createUsers(count);
    }

    public CreateUserTask getCreateUserTask(String id) {
        logger.trace("id: {}", id);
        return new CreateUserTask("id", "status");
    }
}
