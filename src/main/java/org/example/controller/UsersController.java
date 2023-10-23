package org.example.controller;

import org.example.domain.BatchCreateUsersTask;
import org.example.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * ユーザを作成あるいは取得するためのコントローラの実装です。
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService myService) {
        this.userService = myService;
    }

    /**
     * 指定した数のユーザをまとめて作成します。
     * ユーザをまとめて作成する処理は非同期に実行され、このリクエストは即座に返されます。
     * レスポンスにはユーザ作成タスクのロケーションが含まれます。
     * クライアントはタスクのステータス（例. 開始 or 完了）を定期的に監視することができます。
     *
     * @param count 作成するユーザ数
     * @return ユーザ作成タスクのロケーションを含む HTTP レスポンス
     */
    @PostMapping
    public ResponseEntity<?> createUsers(@RequestParam int count) {
        BatchCreateUsersTask task = userService.batchCreateUsers(count);
        return ResponseEntity.accepted().location(UriComponentsBuilder.fromPath("/api/users/tasks/" + task.getId()).build().toUri()).build();
    }

    /**
     * ID を指定してユーザ作成タスクを取得します。
     * この処理は、ユーザをまとめて作成する処理のステータスを監視するために使用します。
     *
     * @param id タスクID
     * @return ユーザ作成タスク
     */
    @GetMapping("/tasks/{id}")
    public BatchCreateUsersTask getCreateUserTask(@PathVariable String id) {
        return userService.getBatchCreateUserTask(id);
    }
}
