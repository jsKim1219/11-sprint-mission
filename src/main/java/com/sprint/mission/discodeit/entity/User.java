package com.sprint.mission.discodeit.entity;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private UUID id;
    private Long createdAt;
    private Long updatedAt;
    private String name;
    private String email;
    private String password;
    private static final long serialVersionUID = 1L;

    public User(String name, String email, String password) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public Long update(String name) {
        this.name = name;
        return updatedAt = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "User{" +
                "id: " + id +
                ", name: " + name +
                ", createdAt: " + createdAt +
                ", updatedAt: " + updatedAt +
                "}";
    }
}
