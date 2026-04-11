package com.sprint.mission.discodeit.service.basic;

import com.sprint.mission.discodeit.dto.MessageCreateRequest;
import com.sprint.mission.discodeit.dto.MessageDto;
import com.sprint.mission.discodeit.dto.MessageUpdateRequest;
import com.sprint.mission.discodeit.entity.BinaryContent;
import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.repository.BinaryContentRepository;
import com.sprint.mission.discodeit.repository.ChannelRepository;
import com.sprint.mission.discodeit.repository.MessageRepository;
import com.sprint.mission.discodeit.repository.UserRepository;
import com.sprint.mission.discodeit.service.MessageService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class BasicMessageService implements MessageService {

  private final MessageRepository messageRepository;
  private final UserRepository userRepository;
  private final ChannelRepository channelRepository;
  private final BinaryContentRepository binaryContentRepository;

  @Override
  public MessageDto create(MessageCreateRequest request, List<MultipartFile> attachments) {
    User author = userRepository.findById(request.authorId())
        .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지  않습니다."));
    Channel channel = channelRepository.findById(request.channelId())
        .orElseThrow(() -> new IllegalArgumentException("채널이 존재하지 않습니다."));

    Message message = new Message(request.content(), author, channel);

    if (attachments != null && !attachments.isEmpty()) {
      List<BinaryContent> attachmentContents = new ArrayList<>();
      for (MultipartFile file : attachments) {
        try {
          BinaryContent content = new BinaryContent(file.getBytes(),
              file.getOriginalFilename(), file.getSize(), file.getContentType());
          binaryContentRepository.save(content);
          attachmentContents.add(content);
        } catch (IOException e) {
          throw new RuntimeException("파일 처리 중 오류 발생", e);
        }
      }
      message.setAttachments(attachmentContents);
    }
    messageRepository.save(message);
    return toDto(message);
  }

  @Override
  public MessageDto findById(UUID id) {
    Message message = messageRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("메시지를 찾을 수 없습니다."));
    return toDto(message);
  }

  @Override
  public List<MessageDto> findAllByChannelId(UUID channelId) {
    return messageRepository.findByChannelId(channelId).stream().
        map(this::toDto).collect(Collectors.toList());
  }

  @Override
  public void update(UUID id, MessageUpdateRequest request) {
    Message message = messageRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("메시지를 찾을 수 없습니다."));
    message.update(request.newContent());
    messageRepository.save(message);
  }

  @Override
  public void delete(UUID id) {
    Message message = messageRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("메시지를 찾을 수 없습니다."));
    if (message.getAttachments() != null) {
      for (BinaryContent attachment : message.getAttachments()) {
        binaryContentRepository.delete(attachment.getId());
      }
    }
    messageRepository.delete(id);
  }

  private MessageDto toDto(Message message) {
    List<UUID> attachmentIds = message.getAttachments().stream().map(BinaryContent::getId)
        .collect(Collectors.toList());

    return new MessageDto(message.getId(), message.getAuthor().getId(),
        message.getChannel().getId(), message.getContent(), attachmentIds,
        message.getCreatedAt(), message.getUpdatedAt());
  }
}
