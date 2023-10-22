package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class MyController {
    private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUsers(@RequestParam int count) {
        myService.createUsers(count);
        return ResponseEntity.accepted().location(UriComponentsBuilder.fromPath("/api/users/tasks/1").build().toUri()).build();
    }

    @GetMapping("/users/tasks/{id}")
    public CreateUserTask getCreateUserTask(String id) {
        return myService.getCreateUserTask(id);
    }
}
