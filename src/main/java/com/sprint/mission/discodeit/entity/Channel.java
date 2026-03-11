package com.sprint.mission.discodeit.entity;

import java.io.Serializable;
import java.util.UUID;

public class Channel implements Serializable {
    private UUID id;
    private Long createdAt;
    private Long updatedAt;
    private String name;
    private String description;
    private static final long serialVersionUID = 1L;
    private ChannelType type;

    public Channel(ChannelType type, String name, String description) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public UUID getId() {
        return this.id;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public Long getUpdatedAt() {
        return this.updatedAt;
    }

    public ChannelType getType() {
        return this.type;
    }

    public Long update(String name) {
        return this.updatedAt = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id: " + id +
                ", name: " + name +
                ", createdAt: " + createdAt +
                ", updatedAt: " + updatedAt +
                "}";
    }
}
