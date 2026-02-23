package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.MessageService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JFCMessageService implements MessageService {
    private final Map<UUID, Message> data;

    public JFCMessageService() {
        this.data = new HashMap<>();
    }

    @Override
    public Message create(String name) {
        Message message = new Message(name);
        data.put(message.getId(), message);
        return message;
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
    public void update(UUID id, String name) {
        Message message = data.get(id);
        if(message != null) {
            message.update(name);
        }
    }

    @Override
    public void delete(UUID id) {
        data.remove(id);
    }
}
