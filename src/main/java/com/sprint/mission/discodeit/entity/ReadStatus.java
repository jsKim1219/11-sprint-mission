package com.sprint.mission.discodeit.entity;

import java.io.Serializable;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public class ReadStatus implements Serializable {

  private static final long serialVersionUID = 1L;
  private UUID id;
  private Instant createdAt;
  private Instant updatedAt;
  private Instant lastReadAt;
  private User user;
  private Channel channel;

  public ReadStatus(User user, Channel channel, Instant lastReadAt) {
    this.id = UUID.randomUUID();
    this.user = user;
    this.channel = channel;
    this.createdAt = Instant.now();
    this.updatedAt = Instant.now();
    this.lastReadAt = (lastReadAt != null) ? lastReadAt : Instant.now();
  }

  public void update(Instant newLastReadAt) {
    if (newLastReadAt != null) {
      this.lastReadAt = newLastReadAt;
    }
    this.updatedAt = Instant.now();
  }
}
