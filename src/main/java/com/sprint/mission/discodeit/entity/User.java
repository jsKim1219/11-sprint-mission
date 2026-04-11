package com.sprint.mission.discodeit.entity;

import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Getter
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  private UUID id;
  private Instant createdAt;
  private Instant updatedAt;
  private String username;
  private String email;
  private String password;
  private BinaryContent profile;
  private UserStatus status;

  public User(String username, String email, String password) {
    this.id = UUID.randomUUID();
    this.createdAt = Instant.now();
    this.updatedAt = Instant.now();
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public Instant update(String username) {
    this.username = username;
    return updatedAt = Instant.now();
  }

  public void updateProfile(BinaryContent profile) {
    this.profile = profile;
    this.updatedAt = Instant.now();
  }

  public void updateStatus(UserStatus status) {
    this.status = status;
  }
}