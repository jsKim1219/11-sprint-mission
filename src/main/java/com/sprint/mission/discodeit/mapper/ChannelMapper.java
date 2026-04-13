package com.sprint.mission.discodeit.mapper;

import com.sprint.mission.discodeit.dto.ChannelDto;
import com.sprint.mission.discodeit.dto.UserDto;
import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;
import com.sprint.mission.discodeit.entity.Message;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChannelMapper {

  private final UserMapper userMapper;

  public ChannelDto toDto(Channel channel) {
    if (channel == null) {
      return null;
    }

    Instant lastMessageAt = null;
    if (channel.getMessages() != null) {
      lastMessageAt = channel.getMessages().stream().map(Message::getCreatedAt)
          .max(Instant::compareTo).orElse(null);
    }

    List<UserDto> participants = null;
    if (channel.getType() == ChannelType.PRIVATE &&
        channel.getReadStatuses() != null) {
      participants = channel.getReadStatuses().stream()
          .map(readStatus -> userMapper.toDto(
              readStatus.getUser())).collect(Collectors.toList());
    } else if (channel.getType() == ChannelType.PUBLIC) {
      participants = Collections.emptyList();
    }

    return new ChannelDto(
        channel.getId(),
        channel.getType(),
        channel.getName(),
        channel.getDescription(),
        participants,
        lastMessageAt
    );
  }
}
