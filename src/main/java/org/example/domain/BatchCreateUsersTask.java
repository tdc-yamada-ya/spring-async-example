package org.example.domain;

/**
 * ユーザをまとめて作成するタスクのエンティティクラスです。
 */
public class BatchCreateUsersTask {
    private final String id;
    private final String status;

    /**
     * @param id タスクID
     * @param status タスクステータス
     */
    public BatchCreateUsersTask(String id, String status) {
        this.id = id;
        this.status = status;
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
}
