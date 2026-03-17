package com.sprint.mission.discodeit.repository.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.repository.MessageRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JCFMessageRepository implements MessageRepository {
    private final Map<UUID, Message> data = new HashMap<>();

    @Override
    public void save(Message message) {
        data.put(message.getId(), message);
    }

    @Override
    public Message findById(UUID id) {
        return data.get(id);
    }

    @Override
    public List<Message> findAll() {
        return data.values().stream().toList();
    }

    @Override
    public void delete(UUID id) {
        data.remove(id);
    }

    @Override
    public List<Message> findByChannelId(UUID channelId) {
        return data.values().stream().
                filter(message ->
                        message.getChannelId().equals(channelId)).toList();
    }

    @Override
    public void deleteByChannelId(UUID channelId) {
        data.values().removeIf(message ->
                message.getChannelId().equals(channelId));
    }
}