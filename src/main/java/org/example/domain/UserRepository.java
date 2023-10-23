package org.example.domain;

/**
 * ユーザの保存・取得を行うリポジトリインタフェースです。
 */
public interface UserRepository {
    User save(User user);
}
