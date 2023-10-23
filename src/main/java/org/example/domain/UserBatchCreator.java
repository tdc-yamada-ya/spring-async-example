package org.example.domain;

/**
 * ユーザをまとめて作成するタスクを実行するコンポーネントインタフェースです。
 */
public interface UserBatchCreator {
    void createUsers(BatchCreateUsersTask task, int count);
}
