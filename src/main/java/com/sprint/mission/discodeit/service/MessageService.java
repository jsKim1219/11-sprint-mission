package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.Message;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    Message create(String name, UUID userId, UUID channelId);
    Message findById(UUID id);
    List<Message> findAll();
    void update(UUID id, String name);
    void delete(UUID id);
}
