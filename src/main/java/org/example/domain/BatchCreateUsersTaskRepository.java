package org.example.domain;

/**
 * ユーザをまとめて作成するタスクの保存および取得を行うためのリポジトリインタフェースです。
 */
public interface BatchCreateUsersTaskRepository {
    /**
     * タスクを保存します。
     *
     * @param task タスク
     * @return 保存されたタスク
     */
    BatchCreateUsersTask save(BatchCreateUsersTask task);

    /**
     * タスクを取得します。
     * @param id タスク ID
     * @return タスク
     */
    BatchCreateUsersTask get(String id);
}
