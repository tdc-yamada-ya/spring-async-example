package org.example.infrastructure;

import org.example.domain.BatchCreateUsersTask;
import org.example.domain.BatchCreateUsersTaskRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class BatchCreateUsersTaskRepositoryImpl implements BatchCreateUsersTaskRepository {
    @Override
    public BatchCreateUsersTask save(BatchCreateUsersTask task) {
        // TODO データベースにデータを登録する処理を実装してください。
        return new BatchCreateUsersTask(task.getId() == null ? UUID.randomUUID().toString() : task.getId(), task.getStatus());
    }

    @Override
    public BatchCreateUsersTask get(String id) {
        // TODO データベースからデータを取得する処理を実装してください。
        return new BatchCreateUsersTask(id, "started");
    }
}
