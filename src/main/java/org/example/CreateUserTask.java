package org.example;

public class CreateUserTask {
    private final String id;
    private final String status;

    public CreateUserTask(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
