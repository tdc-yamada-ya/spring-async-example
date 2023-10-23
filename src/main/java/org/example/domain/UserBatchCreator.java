package org.example.domain;

/**
 * ユーザをまとめて作成するタスクを実行するコンポーネントインタフェースです。
 */
public interface UserBatchCreator {
    /**
     * ユーザ作成タスクを開始します。
     * @return ユーザ作成タスク
     */
    BatchCreateUsersTask createTask();

    /**
     * ユーザ作成処理を実行します。
     * @param task タスク
     * @param count ユーザ作成件数
     */
    void createUsers(BatchCreateUsersTask task, int count);
}
