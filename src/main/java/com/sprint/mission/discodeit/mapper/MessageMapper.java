package com.sprint.mission.discodeit.mapper;

import com.sprint.mission.discodeit.dto.BinaryContentDto;
import com.sprint.mission.discodeit.dto.MessageDto;
import com.sprint.mission.discodeit.entity.Message;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageMapper {

  private final UserMapper userMapper;
  private final BinaryContentMapper binaryContentMapper;

  public MessageDto toDto(Message message) {
    if (message == null) {
      return null;
    }

    List<BinaryContentDto> attachments = message.getAttachments() != null
        ? message.getAttachments().stream().map(binaryContentMapper::toDto)
        .collect(Collectors.toList()) : Collections.emptyList();

    return new MessageDto(
        message.getId(),
        message.getCreatedAt(),
        message.getUpdatedAt(),
        message.getContent(),
        message.getChannel() != null ? message.getChannel().getId() : null,
        message.getAuthor() != null ? userMapper.toDto(message.getAuthor()) : null,
        attachments
    );
  }
}
