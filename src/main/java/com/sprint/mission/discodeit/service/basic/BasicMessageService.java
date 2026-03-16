package com.sprint.mission.discodeit.service.basic;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.repository.ChannelRepository;
import com.sprint.mission.discodeit.repository.MessageRepository;
import com.sprint.mission.discodeit.repository.UserRepository;
import com.sprint.mission.discodeit.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BasicMessageService implements MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ChannelRepository channelRepository;

    @Override
    public Message create(String name, UUID userId, UUID channelId) {
        if (userRepository.findById(userId) == null) {
            throw new IllegalArgumentException("유저가 존재하지 않습니다.");
        }
        if (channelRepository.findById(channelId) == null) {
            throw new IllegalArgumentException("채널이 존재하지 않습니다.");
        }

        Message message = new Message(name, userId, channelId);
        messageRepository.save(message); // 저장소 활용
        return message;
    }

    @Override
    public Message findById(UUID id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public void update(UUID id, String name) {
        Message message = messageRepository.findById(id);
        if (message != null) {
            message.update(name);
            messageRepository.save(message);
        }
    }

    @Override
    public void delete(UUID id) {
        messageRepository.delete(id);
    }
}
