package org.example.domain;

/**
 * ユーザのエンティティクラスです。
 */
public class User {
    private final String id;
    private final String name;

    /**
     * @param id ユーザID
     * @param name ユーザ名
     */
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return ユーザID
     */
    public String getId() {
        return id;
    }

    /**
     * @return ユーザ名
     */
    public String getName() {
        return name;
    }
}
