package org.example.domain;

/**
 * ユーザの作成・取得を行うサービスインタフェースです。
 */
public interface UserService {
    /**
     * 指定した数のユーザをまとめて作成します。
     * 戻り値としてユーザ作成タスクを返します。
     *
     * @param count 作成するユーザ数
     * @return ユーザ作成タスク
     */
    BatchCreateUsersTask batchCreateUsers(int count);

    /**
     * IDを指定してユーザ作成タスクを取得します。
     *
     * @param id タスクID
     * @return タスク
     */
    BatchCreateUsersTask getBatchCreateUserTask(String id);
}
