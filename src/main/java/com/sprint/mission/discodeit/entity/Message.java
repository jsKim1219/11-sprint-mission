package com.sprint.mission.discodeit.entity;

import java.io.Serializable;
import java.util.UUID;

public class Message implements Serializable {
    private UUID id;
    private Long createdAt;
    private Long updatedAt;
    private String content;
    private static final long serialVersionUID = 1L;
    private UUID userId;
    private UUID channelId;

    public Message(String content, UUID userId, UUID channelId) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.content = content;
        this.userId = userId;
        this.channelId = channelId;
    }

    public UUID getId() {
        return this.id;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getChannelId() {
        return channelId;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public Long getUpdatedAt() {
        return this.updatedAt;
    }

    public Long update(String name) {
        return this.updatedAt = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Message{" +
                "id: " + id +
                ", name: " + content +
                ", userId: " + userId +
                ", channelId: " + channelId +
                ", createdAt: " + createdAt +
                ", updatedAt: " + updatedAt +
                "}";
    }
}
