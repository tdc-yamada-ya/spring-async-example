package org.example.domain;

import java.time.Instant;

/**
 * ユーザをまとめて作成するタスクのエンティティクラスです。
 */
public class BatchCreateUsersTask {
    private final String id;
    private final String status;
    private final Instant createdAt;
    private final Instant updatedAt;

    /**
     * @param id タスクID
     * @param status タスクステータス
     * @param createdAt 作成日時
     * @param updatedAt 更新日時
     */
    public BatchCreateUsersTask(String id, String status, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * @return タスクID
     */
    public String getId() {
        return id;
    }

    /**
     * @return タスクステータス
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return 作成日時
     */
    public Instant getCreatedAt() {
        return createdAt;
    }

    /**
     * @return 更新日時
     */
    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
