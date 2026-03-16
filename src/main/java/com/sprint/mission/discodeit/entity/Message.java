package com.sprint.mission.discodeit.entity;

import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Getter
public class Message implements Serializable {
    private UUID id;
    private Instant createdAt;
    private Instant updatedAt;
    private String content;
    private static final long serialVersionUID = 1L;
    private UUID userId;
    private UUID channelId;

    public Message(String content, UUID userId, UUID channelId) {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
        this.content = content;
        this.userId = userId;
        this.channelId = channelId;
    }

    public Instant update(String name) {
        return this.updatedAt = Instant.now();
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
