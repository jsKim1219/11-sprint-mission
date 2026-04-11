package com.sprint.mission.discodeit.entity;

import java.util.ArrayList;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
public class Message implements Serializable {

  private static final long serialVersionUID = 1L;
  private UUID id;
  private List<BinaryContent> attachments = new ArrayList<>();
  private Instant createdAt;
  private Instant updatedAt;
  private String content;
  private User author;
  private Channel channel;


  public Message(String content, User author, Channel channel) {
    this.id = UUID.randomUUID();
    this.createdAt = Instant.now();
    this.content = content;
    this.author = author;
    this.channel = channel;
  }

  public void update(String content) {
    this.content = content;
    this.updatedAt = Instant.now();
  }

  public void setAttachments(List<BinaryContent> attachments) {
    this.attachments = attachments;
  }
}
